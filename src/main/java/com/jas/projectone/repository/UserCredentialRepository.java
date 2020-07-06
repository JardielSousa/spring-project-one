package com.jas.projectone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jas.projectone.model.UserCredential;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {

	UserCredential findByUsername(String username);
	
}
