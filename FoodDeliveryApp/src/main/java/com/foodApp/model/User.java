package com.foodApp.model;

import java.sql.Timestamp;

public class User {
	private int uid;
	private String username;
	private String email;
	private String password;
	private long mobile;
	private String role;
	private String address;
	private Timestamp account_created;
	private Timestamp last_login;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getAccount_created() {
		return account_created;
	}

	public void setAccount_created(Timestamp account_created) {
		this.account_created = account_created;
	}

	public Timestamp getLast_login() {
		return last_login;
	}

	public void setLast_login(Timestamp last_login) {
		this.last_login = last_login;
	}

	public User(int uid, String username, String email, String password, long mobile, String role, String address,
			Timestamp account_created, Timestamp last_login) {
		super();
		this.uid = uid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.account_created = account_created;
		this.last_login = last_login;
	}
	public User(String username, String email, String password, long mobile, String role, String address) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.role = role;
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", mobile=" + mobile + ", account_created=" + account_created + ", last_login=" + last_login + "]";
	}

}
