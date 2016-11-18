package com.mallbywjz.entity;

/**
 * Admins entity. @author MyEclipse Persistence Tools
 */

public class Admins implements java.io.Serializable {

	// Fields

	private String adminId;
	private String pwd;

	// Constructors

	/** default constructor */
	public Admins() {
	}

	/** full constructor */
	public Admins(String pwd) {
		this.pwd = pwd;
	}

	// Property accessors

	public String getAdminId() {
		return this.adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}