package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.util.CoDecUtil;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;
import com.app.validator.CustomerValidator;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerService service;
	@Autowired
	private CustomerValidator custValidator;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private CoDecUtil coDecUtil;
	@Autowired
	private CodeUtil codeUtil;

	//show customer registration page
	@RequestMapping("/regCust")
	public String showRegCust(){
		return "CustReg";
	}

	//validate customer name and email for duplication
	//save customer to database
	//send email to customer after successful registration means saving in table
	@RequestMapping("/saveCust")
	public String savingCust(@ModelAttribute("customer")Customer customer,ModelMap map){
//		StopWatch w=new StopWatch();
//		w.start();
		String token=codeUtil.genTok();
		String pwd=codeUtil.genPwd();

		if(custValidator.doValidate(customer).isEmpty()){
			customer.setCustAccTok(coDecUtil.doEncode(token));
			customer.setCustPwd(coDecUtil.doEncode(pwd));
			int i=service.saveCustomer(customer);
			String mailSubMsg="<b style='color:blue;'>Customer Successfully saved with id::</b><p><font color='red'>"+i+",</font></p><br><strong> With TokenId:: <p><font color='red'>"+token+",</font></p><br> With Password:: <p><font color='red'>"+pwd+"</font></p><br>Please save this details for future reference.</strong>";
			map.addAttribute("msg","Customer Successfully saved with id:: "+i);
			try {
				commonUtil.sendEmail(customer.getCustEmail(), "Welcome to VendorManagement,Mr/Ms:: "+customer.getCustName(),mailSubMsg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			map.addAttribute("msg","Registration Failed because of the below reasons,::");
			map.addAttribute("errList",custValidator.doValidate(customer));
		}
//		w.stop();
//		System.out.println(w.prettyPrint());
		return "CustReg";
	}
}
