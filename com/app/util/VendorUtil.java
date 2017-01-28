package com.app.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Vendor;
import com.app.service.IVendorService;

@Component
public class VendorUtil {
	@Autowired
	private IVendorService service;
	public List<Vendor> getAllVendors(){
		return service.getAllVendors();
	}
}
