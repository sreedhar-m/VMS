package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="ITEM_TAB")
@XmlRootElement(name = "someName")
public class Item {
	@Id
	@SequenceGenerator(name = "I_seq", sequenceName = "ITEM_SEQ",allocationSize=1,initialValue= 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="I_seq")
	@Column(name="item_id")
	private int itemId;
	@Column(name="item_name")
	private String itemName;
	@Column(name="item_cost")
	private double itemCost;
	@Column(name="cust_id")
	private int custId;
	
	
	
	public Item() {
	}
	public Item(int itemId) {
		this.itemId = itemId;
	}
	public Item(int itemId, String itemName, double itemCost, int custId) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCost = itemCost;
		this.custId = custId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemCost() {
		return itemCost;
	}
	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemCost=" + itemCost + ", custId=" + custId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + custId;
		long temp;
		temp = Double.doubleToLongBits(itemCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + itemId;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
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
		Item other = (Item) obj;
		if (custId != other.custId)
			return false;
		if (Double.doubleToLongBits(itemCost) != Double
				.doubleToLongBits(other.itemCost))
			return false;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}
	
	
	
	
	
	
}
