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
@Table(name="cust_tab")
public class Customer {

	@Id
	@Column(name="cust_id")
	@SequenceGenerator(name = "c_seq", sequenceName = "cust_SEQ",allocationSize=1,initialValue= 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="c_seq")
	private int custId;
	@Column(name="cust_name")
	private String custName;
	@Column(name="cust_email")
	private String custEmail;
	@Column(name="cust_type")
	private String custType;
	@Column(name="cust_add")
	private String custAdd;
	@Column(name="cust_pwd")
	private String custPwd;
	@Column(name="cust_acctok")
	private String custAccTok;
	
	public Customer() {
	
	}
	public Customer(int custId, String custName, String custEmail, String custType, String custAdd, String custPwd,
			String custAccTok) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custType = custType;
		this.custAdd = custAdd;
		this.custPwd = custPwd;
		this.custAccTok = custAccTok;
	}
	public Customer(int custId) {
		super();
		this.custId = custId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getCustAdd() {
		return custAdd;
	}
	public void setCustAdd(String custAdd) {
		this.custAdd = custAdd;
	}
	public String getCustPwd() {
		return custPwd;
	}
	public void setCustPwd(String custPwd) {
		this.custPwd = custPwd;
	}
	public String getCustAccTok() {
		return custAccTok;
	}
	public void setCustAccTok(String custAccTok) {
		this.custAccTok = custAccTok;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custType="
				+ custType + ", custAdd=" + custAdd + ", custPwd=" + custPwd + ", custAccTok=" + custAccTok + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custAccTok == null) ? 0 : custAccTok.hashCode());
		result = prime * result + ((custAdd == null) ? 0 : custAdd.hashCode());
		result = prime * result + ((custEmail == null) ? 0 : custEmail.hashCode());
		result = prime * result + custId;
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((custPwd == null) ? 0 : custPwd.hashCode());
		result = prime * result + ((custType == null) ? 0 : custType.hashCode());
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
		Customer other = (Customer) obj;
		if (custAccTok == null) {
			if (other.custAccTok != null)
				return false;
		} else if (!custAccTok.equals(other.custAccTok))
			return false;
		if (custAdd == null) {
			if (other.custAdd != null)
				return false;
		} else if (!custAdd.equals(other.custAdd))
			return false;
		if (custEmail == null) {
			if (other.custEmail != null)
				return false;
		} else if (!custEmail.equals(other.custEmail))
			return false;
		if (custId != other.custId)
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (custPwd == null) {
			if (other.custPwd != null)
				return false;
		} else if (!custPwd.equals(other.custPwd))
			return false;
		if (custType == null) {
			if (other.custType != null)
				return false;
		} else if (!custType.equals(other.custType))
			return false;
		return true;
	}
	
}
