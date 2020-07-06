package com.jas.projectone.configuration;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jas.projectone.enumeration.AuthorityEnum;
import com.jas.projectone.model.UserCredential;

public class Credential implements UserDetails {

	private static final long serialVersionUID = 713312818319169092L;
	
	private UserCredential userCredential;
	
	public Credential(UserCredential userCredential) {
		this.userCredential = userCredential;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.userCredential.getAuthorities().stream()
				.map(AuthorityEnum::name).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toSet());
	}

	@Override
	public String getPassword() {
		return this.userCredential.getPassword();
	}

	@Override
	public String getUsername() {
		return this.userCredential.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.userCredential.isEnable();
	}

}
