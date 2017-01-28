package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;

@Service
public class VendorServiceImpl implements IVendorService {
    @Autowired
	private IVendorDao dao;
	public int saveVendor(Vendor v) {
		// TODO Auto-generated method stub
		return dao.saveVendor(v);
	}
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		return dao.getAllVendors();
	}
	
	public void deleteVenById(int venId) {
		// TODO Auto-generated method stub
		dao.deleteVenById(venId);
	}
	public void updateVendor(Vendor v) {
		// TODO Auto-generated method stub
		dao.updateVendor(v);
	}
	public Vendor getVendorById(int venId) {
		// TODO Auto-generated method stub
		return dao.getVendorById(venId);
	}
	
	public boolean isVendorNameExist(String venName) {
		// TODO Auto-generated method stub
		return dao.isVendorNameExist(venName);
	}
	
	public boolean isVendorEmailExist(String venEmail) {
		// TODO Auto-generated method stub
		return dao.isVendorEmailExist(venEmail);
	}
}
