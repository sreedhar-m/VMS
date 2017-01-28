package com.app.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Location;
import com.app.service.ILocationService;

@Component
public class LocationValidator {
	@Autowired
	public ILocationService service;
   
	//doing validations and returning errors
	public List<String> doValidate(Location loc){
		List<String> errList=new ArrayList<String>();
		if(service.isLocationNameExist(loc.getLocName())){
		 
			errList.add("Location Name "+loc.getLocName()+"already exists");
		}
		return errList;
	}
	
	//checking for location used by vendor or not
	public String deleteValidate(int locId){
		String msg=null;
		if(service.isLocationBindWithVendor(locId)){
			msg="Cannot delete location with id "+locId+" .It is using by a vendor";
		}
		return msg;
	}
	
}
