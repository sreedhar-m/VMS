package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.model.User;
import com.app.service.IUserService;
import com.app.util.CommonUtil;
import com.app.validator.UserValidator;

@Controller
@SessionAttributes("unSession")
public class UserController {

	@Autowired
	private IUserService service;
    @Autowired
	private UserValidator validator;
    @Autowired
    private CommonUtil commonUtil;
	//show user reg page
	@RequestMapping("/regUser")
	public String showUserReg(){
		return "UserReg";
	}
	//save user to db
	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute()User user,ModelMap map){

		if(validator.doValidate(user).isEmpty())
		{
			int id=service.saveUser(user);
			map.addAttribute("msg","User Registration successful with ID:: "+id);
			String mailSubMsg="<b style='color:blue;'>Registered Successfully as User with id::</b><p><font color='red'>"+id+",</font></p><br><strong>Please save this details for future reference.</strong>";
			try {
				commonUtil.sendEmail(user.getUserEmail(), "Welcome to VendorManagement,Mr/Ms:: "+user.getUserName(),mailSubMsg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			map.addAttribute("msg","Registration Failed because of the below reasons,::");
			map.addAttribute("errList",validator.doValidate(user));
		}

		return "UserReg";
	}
	
	//show view for user login
	@RequestMapping("/loginUser")
	public String userLoginView(){
	   	return "UserLoginPage";
		
	}
	
	//validate user
	@RequestMapping("/authUser")
	public String authUser(@RequestParam("un")String uname,@RequestParam("pwd")String password,ModelMap map){
		String page=null;
		if(service.isUserExistWithUnameAndPwd(uname, password)){
			map.addAttribute("unSession",uname);
			page="home";
		}else{
			page="UserLoginPage";
			map.addAttribute("msg","Invalid Login details");
		}
		return page;
	}
	
	//logout user and kill the session
	@RequestMapping("/logOut")
	public String userOut(HttpServletRequest req){
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.removeAttribute("unSession");
		    session.invalidate();
		}
		return "UserLoginPage";
	}

}
