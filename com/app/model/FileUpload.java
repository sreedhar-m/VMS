package com.app.model;



import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="file_tab")
@Entity
public class FileUpload {
	@Id
	@Column(name="f_id")
	@SequenceGenerator(name = "f_seq", sequenceName = "FIL_SEQ",allocationSize=1,initialValue= 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="f_seq")
    private int fileId;
	@Column(name="f_name")
    private String fileName;
	@Column(name="f_data")
	@Lob
    private byte[] fileData;
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(fileData);
		result = prime * result + fileId;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileUpload other = (FileUpload) obj;
		if (!Arrays.equals(fileData, other.fileData))
			return false;
		if (fileId != other.fileId)
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		return true;
	}
	public FileUpload(int fileId, String fileName, byte[] fileData) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileData = fileData;
	}
	public FileUpload() {
		super();
	}
	public FileUpload(int fileId) {
		super();
		this.fileId = fileId;
	}
	
}
