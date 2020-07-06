package com.jas.projectone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jas.projectone.dto.UserCredentialDto;
import com.jas.projectone.model.UserCredential;
import com.jas.projectone.repository.UserCredentialRepository;

@Service
public class UserCredentialService extends AbstractService<UserCredential, UserCredentialRepository> {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserCredential findByUsername(String username) {
		return this.repository.findByUsername(username);
	}

	public void create(UserCredentialDto userCredentialDto) {
		UserCredential userCredential = userCredentialDto.parse();
		userCredential.setPassword(this.passwordEncoder.encode(userCredential.getPassword()));
		this.repository.save(userCredential);
	}
}
