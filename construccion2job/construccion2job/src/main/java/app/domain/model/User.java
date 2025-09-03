package app.domain.model;

import app.domain.model.enums.Role;

public class User extends Person{
	
	private Role rol;
	private String userName;
	private String password;
	private String gender;
	
	public Role getRol() {
		return rol;
	}
	public void setRol(Role rol) {
		this.rol = rol;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
