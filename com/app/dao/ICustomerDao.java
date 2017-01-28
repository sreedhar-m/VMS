package com.app.dao;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerDao {
     
	int saveCustomer(Customer c);
	List<Customer> getAllCustomers();
	boolean isCustomerNameExist(String custName);
	boolean isCustomerEmailExist(String custEmail);
	public Customer getCustByEmail(String email);
}
