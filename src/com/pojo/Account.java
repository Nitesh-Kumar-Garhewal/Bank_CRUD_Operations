package com.pojo;

public class Account {
	// actid   name  balance   username   password
	
	
	private int actid;
	private String name;
	private double balance;
	private String username;
	private String password;
	public int getActid() {
		return actid;
	}
	public void setActid(int actid) {
		this.actid = actid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Account [actid=" + actid + ", name=" + name + ", balance=" + balance + ", username=" + username
				+ ", password=" + password + "]";
	}
	public Account(int actid, String name, double balance, String username, String password) {
		 
		this.actid = actid;
		this.name = name;
		this.balance = balance;
		this.username = username;
		this.password = password;
		
		 
	}
	public Account() {
		 
	}
	public Account(int actid, String name, String password) {
		super();
		this.actid = actid;
		this.name = name;
		this.password = password;
	}
	
	
	
	//pojo:plain old java object
	//class with data members,contrs,getters setters,toString
	
	
	

}
