package com.app.dao;

import java.util.List;

import com.app.model.Location;

public interface ILocationDao {
   int saveLocation(Location loc);
   List<Location> getAllLocations();
   void deleteLocById(int id);
   Location getLocationById(int locId);
   void UpdateLocation(Location loc);
   boolean isLocationNameExist(String locName);
   boolean isLocationBindWithVendor(int locId);
   List<Object[]> getLocwiseCount();
}
