package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDao dao;
	public int saveCustomer(Customer c) {
		// TODO Auto-generated method stub
		return dao.saveCustomer(c);
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return dao.getAllCustomers();
	}	
	
	public boolean isCustomerEmailExist(String custEmail) {
		// TODO Auto-generated method stub
		return dao.isCustomerEmailExist(custEmail);
	}
	
	public boolean isCustomerNameExist(String custName) {
		// TODO Auto-generated method stub
		return dao.isCustomerNameExist(custName);
	}

	public Customer getCustByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.getCustByEmail(email);
	}
}
