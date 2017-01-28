package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
@Repository
public class CustomerDaoImpl implements ICustomerDao{
	@Autowired
	private HibernateTemplate ht;

	public int saveCustomer(Customer c) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(c);
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return ht.loadAll(Customer.class);
	}

	public boolean isCustomerNameExist(String custName) {
		String hql="from "+Customer.class.getName()+" where custName=?";
		List list=ht.find(hql,custName);
		if(list.isEmpty()){
			return true;
		}else{
			return false;
		}
	}

	public boolean isCustomerEmailExist(String custEmail) {
		if(ht.find("from "+Customer.class.getName()+" where custEmail=?",custEmail).isEmpty()){
			return false;
		}
		else{
			return true;
		}

	}

	public Customer getCustByEmail(String email) {
		
		List list=ht.find("from "+Customer.class.getName()+" where custEmail=?",email);
		if(list==null || list.isEmpty())
			return null;
		else{
			return (Customer)list.get(0);
		}
	}
}
