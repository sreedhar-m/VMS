package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_tab")
public class User {
    @Id
    @Column(name="u_id")
    @SequenceGenerator(name = "u_seq", sequenceName = "user_SEQ",allocationSize=1,initialValue= 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="u_seq")
	private int userId;
    @Column(name="u_name")
	private String userName;
    @Column(name="u_email")
	private String userEmail;
    @Column(name="u_pwd")
	private String userPassword;
    @Column(name="u_regno")
	private String userRegNo;
    @Column(name="u_addr")
	private String userAddr;
	public User() {
	}
	public User(int userId, String userName, String userEmail, String userPassword, String userRegNo, String userAddr) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRegNo = userRegNo;
		this.userAddr = userAddr;
	}
	public User(int userId) {
		super();
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRegNo() {
		return userRegNo;
	}
	public void setUserRegNo(String userRegNo) {
		this.userRegNo = userRegNo;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userAddr == null) ? 0 : userAddr.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result + ((userRegNo == null) ? 0 : userRegNo.hashCode());
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
		User other = (User) obj;
		if (userAddr == null) {
			if (other.userAddr != null)
				return false;
		} else if (!userAddr.equals(other.userAddr))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		if (userRegNo == null) {
			if (other.userRegNo != null)
				return false;
		} else if (!userRegNo.equals(other.userRegNo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userRegNo=" + userRegNo + ", userAddr=" + userAddr + "]";
	}
	
	
}
