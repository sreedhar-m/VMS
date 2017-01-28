package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILocationDao;
import com.app.model.Location;
import com.app.service.ILocationService;


@Service
public class LocationServiceImpl implements ILocationService {
	@Autowired
	private ILocationDao dao;
	public int saveLocation(Location loc) {

		return dao.saveLocation(loc);
	}
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		return dao.getAllLocations();
	}

	public void deleteLocById(int id) {
		// TODO Auto-generated method stub
		dao.deleteLocById(id);
	}

	public Location getLocationById(int locId) {
		// TODO Auto-generated method stub
		return dao.getLocationById(locId);	
	}

	public void UpdateLocation(Location loc) {
		// TODO Auto-generated method stub
		dao.UpdateLocation(loc);
	}
	public boolean isLocationNameExist(String locName) {
		// TODO Auto-generated method stub
		return dao.isLocationNameExist(locName);
	}
	
	public boolean isLocationBindWithVendor(int locId) {
		// TODO Auto-generated method stub
		return dao.isLocationBindWithVendor(locId);
	}
	
	public List<Object[]> getLocwiseCount() {
		// TODO Auto-generated method stub
		return dao.getLocwiseCount();
	}
}
