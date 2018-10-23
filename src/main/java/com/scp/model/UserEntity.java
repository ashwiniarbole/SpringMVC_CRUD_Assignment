package com.scp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_firstname")
	private String fname;
	
	@Column(name = "user_surname")
	private String lname;
	
	@Column(name = "user_address")
	private String uAddress;
	
	@Column(name = "user_phone")
	private int userPhone;

	
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public int getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}



	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", uAddress=" + uAddress
				+ ", userPhone=" + userPhone + "]";
	}



	public UserEntity(int userId, String fname, String lname, String uAddress, int userPhone) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.uAddress = uAddress;
		this.userPhone = userPhone;
	}

	public UserEntity() {
		
	}

}
