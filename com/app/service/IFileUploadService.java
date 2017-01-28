package com.app.service;

import java.util.List;

import com.app.model.FileUpload;

public interface IFileUploadService {
	void saveFile(FileUpload file);
	List<Object[]> getFilesDetails();
}
