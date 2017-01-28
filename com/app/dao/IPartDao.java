package com.app.dao;

import java.util.List;

import com.app.model.Location;
import com.app.model.Part;

public interface IPartDao {

	int savePart(Part p);
	List<Part> showAllParts();
	void updatePart(Part p);
	void deletePartById(int partId);
	Part getPartById(int partId);
}
