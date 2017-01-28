package com.app.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="part_tab")
public class Part {
	@Id
	@Column(name="pa_id")
	@SequenceGenerator(name = "p_seq", sequenceName = "PART_SEQ",allocationSize=1,initialValue= 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="p_seq")
	private int partId;
	@Column(name="pa_name")
	private String partName;
	@Column(name="pa_mode")
	private String partMode;
	@Column(name="pa_cost")
	private double partCost;
	@OneToMany
	@JoinColumn(name="ven_fk")
	private List<Vendor> ven;
	public Part(int partId, String partName, String partMode, double partCost, List<Vendor> ven) {
		super();
		this.partId = partId;
		this.partName = partName;
		this.partMode = partMode;
		this.partCost = partCost;
		this.ven = ven;
	}
	public Part() {
		super();
	}
	public Part(int partId) {
		super();
		this.partId = partId;
	}
	public int getPartId() {
		return partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getPartMode() {
		return partMode;
	}
	public void setPartMode(String partMode) {
		this.partMode = partMode;
	}
	public double getPartCost() {
		return partCost;
	}
	public void setPartCost(double partCost) {
		this.partCost = partCost;
	}
	public List<Vendor> getVen() {
		return ven;
	}
	public void setVen(List<Vendor> ven) {
		this.ven = ven;
	}
	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partName=" + partName + ", partMode=" + partMode + ", partCost=" + partCost
				+ ", ven=" + ven + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(partCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + partId;
		result = prime * result + ((partMode == null) ? 0 : partMode.hashCode());
		result = prime * result + ((partName == null) ? 0 : partName.hashCode());
		result = prime * result + ((ven == null) ? 0 : ven.hashCode());
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
		Part other = (Part) obj;
		if (Double.doubleToLongBits(partCost) != Double.doubleToLongBits(other.partCost))
			return false;
		if (partId != other.partId)
			return false;
		if (partMode == null) {
			if (other.partMode != null)
				return false;
		} else if (!partMode.equals(other.partMode))
			return false;
		if (partName == null) {
			if (other.partName != null)
				return false;
		} else if (!partName.equals(other.partName))
			return false;
		if (ven == null) {
			if (other.ven != null)
				return false;
		} else if (!ven.equals(other.ven))
			return false;
		return true;
	}


}
