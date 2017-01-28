package com.app.dao;

import java.util.List;

import com.app.model.FileUpload;

public interface IFileUploadDao {
  void saveFile(FileUpload file);
  List<Object[]> getFilesDetails();
  FileUpload getFileById(int fileId);
}
