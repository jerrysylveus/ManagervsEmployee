package com.revature.pojo;

public class UserPojo {
	private int u_id;
	private String u_userName;
	private String u_password;
	private String u_firstName;
	private String u_lastName;
	private String u_email;
	private int userRolesId;
	
	
	
	
	public UserPojo() {}




	public UserPojo(int u_id, String u_userName, String u_password, String u_firstName, String u_lastName,
			String u_email, int userRolesId) {
		super();
		this.u_id = u_id;
		this.u_userName = u_userName;
		this.u_password = u_password;
		this.u_firstName = u_firstName;
		this.u_lastName = u_lastName;
		this.u_email = u_email;
		this.userRolesId = userRolesId;
	}




	public int getU_id() {
		return u_id;
	}




	public void setU_id(int u_id) {
		this.u_id = u_id;
	}




	public String getU_userName() {
		return u_userName;
	}




	public void setU_userName(String u_userName) {
		this.u_userName = u_userName;
	}




	public String getU_password() {
		return u_password;
	}




	public void setU_password(String u_password) {
		this.u_password = u_password;
	}




	public String getU_firstName() {
		return u_firstName;
	}




	public void setU_firstName(String u_firstName) {
		this.u_firstName = u_firstName;
	}




	public String getU_lastName() {
		return u_lastName;
	}




	public void setU_lastName(String u_lastName) {
		this.u_lastName = u_lastName;
	}




	public String getU_email() {
		return u_email;
	}




	public void setU_email(String u_email) {
		this.u_email = u_email;
	}




	public int getUserRolesId() {
		return userRolesId;
	}




	public void setUserRolesId(int userRolesId) {
		this.userRolesId = userRolesId;
	}




	@Override
	public String toString() {
		return "UserPojo [u_id=" + u_id + ", u_userName=" + u_userName + ", u_password=" + u_password + ", u_firstName="
				+ u_firstName + ", u_lastName=" + u_lastName + ", u_email=" + u_email + ", userRolesId=" + userRolesId
				+ "]";
	}
	
	

}
