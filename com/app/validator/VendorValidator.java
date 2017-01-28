package com.app.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Vendor;
import com.app.service.IVendorService;

@Component
public class VendorValidator {
    @Autowired
	private IVendorService service;
    
    public List<String> doValidate(Vendor vendor){
    	List<String> list=new ArrayList<String>();
    	
    	if(service.isVendorNameExist(vendor.getVenName())){
    		list.add("Vendor Name already exists");
    	}
    	if(service.isVendorEmailExist(vendor.getVenEmail())){
    		list.add("Vendor Email already exists");
    	}
    		
    	return list;
    }

	
}
