package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="loc_tab")
public class Location {

	@Id
	@Column(name="l_id")
	@SequenceGenerator(name = "l_seq", sequenceName = "LOC_SEQ",allocationSize=1,initialValue= 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="l_seq")
      private int locId;
	@Column(name="l_name")
      private String locName;
	@Column(name="l_type")
      private String locType;
	@Column(name="l_fulladd")
	private String locFullAdd;
	@Column(name="l_regno")
	private Long locRegNo;
	@Column(name="l_tmode")
	private String locTMode;
	@Column(name="l_pmode")
	private String locPMode;
	@Column(name="l_txno")
	private Long locTxNo;
	
	public Location() {
		
	}
	public Location(int locId) {

		this.locId = locId;
	}
	
	public Location(int locId, String locName, String locType, String locFullAdd, Long locRegNo, String locTMode,
			String locPMode, Long locTxNo) {
		
		this.locId = locId;
		this.locName = locName;
		this.locType = locType;
		this.locFullAdd = locFullAdd;
		this.locRegNo = locRegNo;
		this.locTMode = locTMode;
		this.locPMode = locPMode;
		this.locTxNo = locTxNo;
	}
	
	
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	public String getLocType() {
		return locType;
	}
	public void setLocType(String locType) {
		this.locType = locType;
	}
	
	public String getLocFullAdd() {
		return locFullAdd;
	}
	public void setLocFullAdd(String locFullAdd) {
		this.locFullAdd = locFullAdd;
	}
	public Long getLocRegNo() {
		return locRegNo;
	}
	public void setLocRegNo(Long locRegNo) {
		this.locRegNo = locRegNo;
	}
	public String getLocTMode() {
		return locTMode;
	}
	public void setLocTMode(String locTMode) {
		this.locTMode = locTMode;
	}
	public String getLocPMode() {
		return locPMode;
	}
	public void setLocPMode(String locPMode) {
		this.locPMode = locPMode;
	}
	public Long getLocTxNo() {
		return locTxNo;
	}
	public void setLocTxNo(Long locTxNo) {
		this.locTxNo = locTxNo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locFullAdd == null) ? 0 : locFullAdd.hashCode());
		result = prime * result + locId;
		result = prime * result + ((locName == null) ? 0 : locName.hashCode());
		result = prime * result + ((locPMode == null) ? 0 : locPMode.hashCode());
		result = prime * result + ((locRegNo == null) ? 0 : locRegNo.hashCode());
		result = prime * result + ((locTMode == null) ? 0 : locTMode.hashCode());
		result = prime * result + ((locTxNo == null) ? 0 : locTxNo.hashCode());
		result = prime * result + ((locType == null) ? 0 : locType.hashCode());
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
		Location other = (Location) obj;
		if (locFullAdd == null) {
			if (other.locFullAdd != null)
				return false;
		} else if (!locFullAdd.equals(other.locFullAdd))
			return false;
		if (locId != other.locId)
			return false;
		if (locName == null) {
			if (other.locName != null)
				return false;
		} else if (!locName.equals(other.locName))
			return false;
		if (locPMode == null) {
			if (other.locPMode != null)
				return false;
		} else if (!locPMode.equals(other.locPMode))
			return false;
		if (locRegNo == null) {
			if (other.locRegNo != null)
				return false;
		} else if (!locRegNo.equals(other.locRegNo))
			return false;
		if (locTMode == null) {
			if (other.locTMode != null)
				return false;
		} else if (!locTMode.equals(other.locTMode))
			return false;
		if (locTxNo == null) {
			if (other.locTxNo != null)
				return false;
		} else if (!locTxNo.equals(other.locTxNo))
			return false;
		if (locType == null) {
			if (other.locType != null)
				return false;
		} else if (!locType.equals(other.locType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locName=" + locName + ", locType=" + locType + ", locFullAdd="
				+ locFullAdd + ", locRegNo=" + locRegNo + ", locTMode=" + locTMode + ", locPMode=" + locPMode
				+ ", locTxNo=" + locTxNo + "]";
	}
}
