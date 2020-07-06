package com.jas.projectone.enumeration;

public enum AuthorityEnum {
	ADMIN("Admin"),
	USER("User")
	;
	
	private String description;

	private AuthorityEnum(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

}
