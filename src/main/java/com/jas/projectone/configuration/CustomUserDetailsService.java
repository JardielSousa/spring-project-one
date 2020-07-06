package com.jas.projectone.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jas.projectone.model.UserCredential;
import com.jas.projectone.service.UserCredentialService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserCredentialService userCredentialService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserCredential userCredential = this.userCredentialService.findByUsername(username);
		if (userCredential == null) {
			throw new UsernameNotFoundException("Username not found!");
		}
		
		return new Credential(userCredential);
	}

}
