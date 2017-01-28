package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
@Repository
public class VendorDaoImpl implements IVendorDao{
	@Autowired
	private HibernateTemplate ht;
	public int saveVendor(Vendor v){
		return (Integer)ht.save(v);
	}
	public List<Vendor> getAllVendors() {
		List<Vendor> list=ht.loadAll(Vendor.class);
		return list;
	}
	
	public void deleteVenById(int venId) {
		// TODO Auto-generated method stub
	 ht.delete(new Vendor(venId));	
	}
	public void updateVendor(Vendor v) {
		// TODO Auto-generated method stub
		ht.update(v);
	}
	
	public Vendor getVendorById(int venId) {
		// TODO Auto-generated method stub
		return ht.get(Vendor.class,venId);
	}
	
	public boolean isVendorNameExist(String venName) {
		// TODO Auto-generated method stub
		String query="from "+Vendor.class.getName()+" where venName=?";
		@SuppressWarnings("rawtypes")
		List list=ht.find(query, venName);
		if(list.isEmpty()){
		return false;
		}
		return true;
	}
	
	public boolean isVendorEmailExist(String venEmail) {
		// TODO Auto-generated method stub
		String query="from "+Vendor.class.getName()+" where venEmail=?";
		@SuppressWarnings("rawtypes")
		List list=ht.find(query,venEmail);
		if(list.isEmpty()){
		return false;
		}
		return true;
	}
}
