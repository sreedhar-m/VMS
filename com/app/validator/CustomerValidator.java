package com.app.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.util.CoDecUtil;

@Component
public class CustomerValidator {
	@Autowired
	private ICustomerService service;
	@Autowired
	private CoDecUtil cDutil;

	public List<String> doValidate(Customer cust){
		List<String> list=new ArrayList<String>();
		if(service.isCustomerNameExist(cust.getCustName())){
			list.add("Customer Name already exists");
		}
		if(service.isCustomerEmailExist(cust.getCustEmail())){
			list.add("Customer Email already exists");
		}
		return list;
	}

	public boolean isUserExist(String email){
		boolean flag=false;
		if(service.isCustomerEmailExist(email)){
			return flag=true;
		}else{
			return flag;
		}
	}
	
	public boolean isValidSeller(Customer cust,String pwd,String accTock){
		
		boolean flag=false;
		if(pwd!=null && !"".equals(pwd)	&& accTock!=null && !"".equals(accTock)){
			if(cDutil.doDecode(cust.getCustPwd()).equals(pwd) && cDutil.doDecode(cust.getCustAccTok()).equals(accTock) && "Seller".equals(cust.getCustType())){
			
				flag=true;
			}
		}
		
		return flag;
	}
}
