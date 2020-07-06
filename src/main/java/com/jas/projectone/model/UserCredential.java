package com.jas.projectone.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jas.projectone.enumeration.AuthorityEnum;

@Entity
public class UserCredential implements Serializable {

	private static final long serialVersionUID = -2320343012298568507L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String username;
	
	private String password;

	private boolean enable;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "user_authority")
	@Enumerated(EnumType.STRING)
	@Column(name = "authority")
	private Set<AuthorityEnum> authorities;
	
	public UserCredential() {
		this.authorities = new HashSet<>();
		this.authorities.add(AuthorityEnum.USER);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<AuthorityEnum> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<AuthorityEnum> authorities) {
		this.authorities = authorities;
	}
	
}
