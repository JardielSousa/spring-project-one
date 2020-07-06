package com.jas.projectone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<T, R extends JpaRepository<T, Long>> {
	
	@Autowired
	protected R repository;
	
	public List<T> findAll() {
		return this.repository.findAll();
	}
	
	public Optional<T> findById(Long id) {
		return this.repository.findById(id);
	}

}
