package com.bugbycode.module.session;

import java.io.Serializable;
import java.util.Date;

public class SsoSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3809501170597794996L;

	private int id;
	
	private String randomId;
	
	private int resId;
	
	private String userName;
	
	private String account;
	
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRandomId() {
		return randomId;
	}

	public void setRandomId(String randomId) {
		this.randomId = randomId;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
