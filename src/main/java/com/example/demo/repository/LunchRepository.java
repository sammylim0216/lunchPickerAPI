package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Lunch;



public interface LunchRepository extends JpaRepository<Lunch, Long>{

	public Lunch findByLunchId(Long id);
	
}
