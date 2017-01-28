package com.app.service;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorService {
	int saveVendor(Vendor v);
	public List<Vendor> getAllVendors();
	void deleteVenById(int venId);
	Vendor getVendorById(int venId);
	void updateVendor(Vendor v);
	boolean isVendorNameExist(String venName);
	boolean isVendorEmailExist(String venEmail);
}
