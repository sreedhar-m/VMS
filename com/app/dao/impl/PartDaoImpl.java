package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPartDao;
import com.app.model.Part;
@Repository
public class PartDaoImpl implements IPartDao {
	
	@Autowired
	private HibernateTemplate ht;
	
	//save Part
	public int savePart(Part p) {

		return (Integer) ht.save(p);
	}

	//load all parts
	public List<Part> showAllParts() {

		return ht.loadAll(Part.class);
	}

	//update part
	public void updatePart(Part p) {

		ht.update(p);
	}

	//delete part
	public void deletePartById(int partId) {
         ht.delete(new Part(partId));
	}

	//get part by id
	public Part getPartById(int partId) {
		// TODO Auto-generated method stub
		return ht.load(Part.class,partId);
	}


}
