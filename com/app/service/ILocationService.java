package com.app.service;

import java.util.List;

import com.app.model.Location;

public interface ILocationService {
	int saveLocation(Location loc);
	public List<Location> getAllLocations();
	void deleteLocById(int id);
	Location getLocationById(int locId);
	void UpdateLocation(Location loc);
	boolean isLocationNameExist(String locName);
	public boolean isLocationBindWithVendor(int locId);
	List<Object[]> getLocwiseCount();
}
