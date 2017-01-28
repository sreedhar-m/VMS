package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ven_tab")
public class Vendor {
	@Id
	@Column(name="v_id")
	@SequenceGenerator(name = "v_seq", sequenceName = "VEN_SEQ",allocationSize=1,initialValue= 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="v_seq")
	private int venId;
	@Column(name="v_name")
	private String venName;
	@Column(name="v_email")
	private String venEmail;
	@ManyToOne()
	@JoinColumn(name="loc_fk")
	private Location loc;
	@Column(name="v_serType")
	private String venSerType;
	@Column(name="v_mobNum")
	private Long venMobNum;
	@Column(name="v_regId")
	private Long venRegId;
	@Column(name="v_gradeType")
	private Character venGradeType;
	
	public Vendor() {
		super();
	}
	public Vendor(int venId) {
		super();
		this.venId = venId;
	}
	public Vendor(int venId, String venName, String venEmail, Location loc, String venSerType, Long venMobNum,
			Long venRegId, char venGradeType) {
		super();
		this.venId = venId;
		this.venName = venName;
		this.venEmail = venEmail;
		this.loc = loc;
		this.venSerType = venSerType;
		this.venMobNum = venMobNum;
		this.venRegId = venRegId;
		this.venGradeType = venGradeType;
	}
	
	

	public int getVenId() {
		return venId;
	}

	public void setVenId(int venId) {
		this.venId = venId;
	}

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenEmail() {
		return venEmail;
	}

	public void setVenEmail(String venEmail) {
		this.venEmail = venEmail;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}
	public String getVenSerType() {
		return venSerType;
	}
	public void setVenSerType(String venSerType) {
		this.venSerType = venSerType;
	}
	public Long getVenMobNum() {
		return venMobNum;
	}
	public void setVenMobNum(Long venMobNum) {
		this.venMobNum = venMobNum;
	}
	public Long getVenRegId() {
		return venRegId;
	}
	public void setVenRegId(Long venRegId) {
		this.venRegId = venRegId;
	}
	public Character getVenGradeType() {
		return venGradeType;
	}
	public void setVenGradeType(Character venGradeType) {
		this.venGradeType = venGradeType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
		result = prime * result + ((venEmail == null) ? 0 : venEmail.hashCode());
		result = prime * result + venGradeType;
		result = prime * result + venId;
		result = prime * result + ((venMobNum == null) ? 0 : venMobNum.hashCode());
		result = prime * result + ((venName == null) ? 0 : venName.hashCode());
		result = prime * result + ((venRegId == null) ? 0 : venRegId.hashCode());
		result = prime * result + ((venSerType == null) ? 0 : venSerType.hashCode());
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
		Vendor other = (Vendor) obj;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		if (venEmail == null) {
			if (other.venEmail != null)
				return false;
		} else if (!venEmail.equals(other.venEmail))
			return false;
		if (venGradeType != other.venGradeType)
			return false;
		if (venId != other.venId)
			return false;
		if (venMobNum == null) {
			if (other.venMobNum != null)
				return false;
		} else if (!venMobNum.equals(other.venMobNum))
			return false;
		if (venName == null) {
			if (other.venName != null)
				return false;
		} else if (!venName.equals(other.venName))
			return false;
		if (venRegId == null) {
			if (other.venRegId != null)
				return false;
		} else if (!venRegId.equals(other.venRegId))
			return false;
		if (venSerType == null) {
			if (other.venSerType != null)
				return false;
		} else if (!venSerType.equals(other.venSerType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venName=" + venName + ", venEmail=" + venEmail + ", loc=" + loc
				+ ", venSerType=" + venSerType + ", venMobNum=" + venMobNum + ", venRegId=" + venRegId
				+ ", venGradeType=" + venGradeType + "]";
	}
	


	
}
