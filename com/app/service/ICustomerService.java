package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerService {

	int saveCustomer(Customer c);
	List<Customer> getAllCustomers();
	boolean isCustomerNameExist(String custName);
	boolean isCustomerEmailExist(String custEmail);
	public Customer getCustByEmail(String email);
}
