package com.example.model;

import org.springframework.stereotype.Component;

@Component
public class UserModel {
	
	private String name;
	private String password;
	private String permission;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}

	
}
