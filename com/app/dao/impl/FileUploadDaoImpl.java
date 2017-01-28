package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IFileUploadDao;
import com.app.model.FileUpload;

@Repository
public class FileUploadDaoImpl implements IFileUploadDao{
	@Autowired
	private HibernateTemplate ht;
	public void saveFile(FileUpload file) {
        ht.save(file); 
	}
	
	public List<Object[]> getFilesDetails() {
		String query="select fileId,fileName from "+FileUpload.class.getName();
		List<Object[]> list=ht.find(query);
		return list;
	}
	
	public FileUpload getFileById(int fileId) {
		
		return ht.get(FileUpload.class,fileId);
	}
}
