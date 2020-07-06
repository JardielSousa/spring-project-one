package com.jas.projectone.dto;

import com.jas.projectone.model.UserCredential;

public class UserCredentialDto implements InterfaceDto<UserCredential> {
	
	private static final long serialVersionUID = -7470233138177540581L;

	private String name;
	
	private String username;
	
	private String password;
	
	private String confirmPassword;
	
	public UserCredentialDto() { }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public UserCredential parse() {
		UserCredential uc = new UserCredential();
		uc.setName(this.name);
		uc.setUsername(this.username);
		uc.setPassword(this.password);
		
		return uc;
	}

	@Override
	public String toString() {
		return "UserCredentialDto [name=" + name + ", username=" + username + "]";
	}

}
