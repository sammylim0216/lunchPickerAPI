package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Location;
import com.example.demo.entity.Lunch;



public interface LunchLocationRepository extends JpaRepository<Location, Long>{

	public List<Location> findAllByLunchId(Long lunchId);
	
}
