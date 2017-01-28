package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IPartDao;
import com.app.model.Part;
import com.app.service.IPartService;
@Service
public class PartServiceImpl implements IPartService {
@Autowired
	private IPartDao dao;
	public int savePart(Part p) {
		// TODO Auto-generated method stub
		return dao.savePart(p);
	}

	public List<Part> showAllParts() {
		// TODO Auto-generated method stub
		return dao.showAllParts();
	}

	public void updatePart(Part p) {
         
		dao.updatePart(p);
		
	}

	public void deletePartById(int partId) {

		dao.deletePartById(partId);
	}

	public Part getPartById(int partId) {
		// TODO Auto-generated method stub
		return dao.getPartById(partId);
	}


}
