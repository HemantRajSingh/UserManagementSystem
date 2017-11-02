package com.softech.usermanagement.model;

public class User{

	protected int id;
	protected String username;
	protected String fullname;
	protected String password;


	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
	
	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setFullname(String fullname){
		this.fullname = fullname;
	}

	public String getFullname(){
		return fullname;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

}
