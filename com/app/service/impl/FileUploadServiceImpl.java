package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IFileUploadDao;
import com.app.model.FileUpload;
import com.app.service.IFileUploadService;
@Service
public class FileUploadServiceImpl implements IFileUploadService {
    @Autowired
	private IFileUploadDao dao;
	public void saveFile(FileUpload file) {
          dao.saveFile(file);
	}
	
	public List<Object[]> getFilesDetails() {
		// TODO Auto-generated method stub
		return dao.getFilesDetails();
	}

}
