package com.app.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.User;
import com.app.service.IUserService;

@Component
public class UserValidator {

	@Autowired
	private IUserService service;
	
	public List<String> doValidate(User user){
		List<String> errList=new ArrayList<String>();
		
		if(service.isUserExist(user.getUserName())){
    		errList.add("user Name already exists");
    	}
    	if(service.isUserEmailExist(user.getUserEmail())){
    		errList.add("User Email already exists");
    	}
    	
    	return errList;
	}
}
