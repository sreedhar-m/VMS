package com.app.service;

import java.util.List;

import com.app.model.Part;

public interface IPartService {

	int savePart(Part p);
	List<Part> showAllParts();
	void updatePart(Part p);
	void deletePartById(int partId);
	Part getPartById(int partId);
}
