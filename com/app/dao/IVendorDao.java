package com.app.dao;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorDao {
     int saveVendor(Vendor v);
     List<Vendor> getAllVendors();
     void deleteVenById(int venId);
     Vendor getVendorById(int venId);
     void updateVendor(Vendor v);
     boolean isVendorNameExist(String venName);
     boolean isVendorEmailExist(String venEmail);
     
}
