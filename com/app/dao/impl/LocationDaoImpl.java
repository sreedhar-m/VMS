package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ILocationDao;
import com.app.model.Location;
import com.app.model.Vendor;


@Repository
public class LocationDaoImpl implements ILocationDao {
	@Autowired
	private HibernateTemplate ht;
	public int saveLocation(Location loc) {
		return (Integer)ht.save(loc);
	}
	public List<Location> getAllLocations() {
		List<Location> list=ht.loadAll(Location.class);
		return list;
	}
	public void deleteLocById(int id) {
		// TODO Auto-generated method stub
		ht.delete(new Location(id));
	}
	
	public Location getLocationById(int locId) {
      
		return ht.get(Location.class,locId);
		
	}
	public void UpdateLocation(Location loc) {
		ht.update(loc);
		
	}
	
	public boolean isLocationNameExist(String locName) {
		String query="from "+Location.class.getName()+" where locName=?";
		@SuppressWarnings("rawtypes")
		List list=ht.find(query, locName);
		if(list.isEmpty()){
		return false;
		}else{
			return true;
		}
	}
	public boolean isLocationBindWithVendor(int locId) {
		String hql="from "+Vendor.class.getName()+" as ven "
				 +" left join ven.loc as loc "
				 +" where loc.locId=? ";
		
		return ht.find(hql, locId).size()>0;
	}
	
	public List<Object[]> getLocwiseCount() {
		String query="select locType,count(locId) from "+Location.class.getName()+" group by locType";
		return ht.find(query);
	}
}
