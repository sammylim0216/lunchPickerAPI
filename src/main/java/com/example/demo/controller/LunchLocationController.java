package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Location;
import com.example.demo.entity.Lunch;
import com.example.demo.exception.LunchNotFoundException;
import com.example.demo.repository.LunchLocationRepository;
import com.example.demo.repository.LunchRepository;

import io.micrometer.common.util.StringUtils;

@RestController
public class LunchLocationController {
	
	@Autowired
	private LunchLocationRepository repository;
	
	@Autowired
	private LunchRepository lunchRepository;
	
	public LunchLocationController(LunchLocationRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/location/{id}")
	 public String[] one(@PathVariable Long id) {
		
		ArrayList<String> locationArr = new ArrayList<String>();
		String[] locationStrArr = new String[0];
		
		List<Location> locationList = repository.findAllByLunchId(id);
		if(locationList!=null && locationList.size()>0) {
			for(Location location:locationList) {
				locationArr.add(location.getLocation());
			}
			
			locationStrArr = new String[locationArr.size()];
			locationStrArr = locationArr.toArray(locationStrArr);
		} 
		return locationStrArr;
	 }
	
	@PostMapping("/location/addLocation")
	 public Location add(@RequestBody Location newLocation) { 
		
		if(newLocation!=null) {
			Lunch lunch = lunchRepository.findByLunchId(newLocation.getLunchId());
			if(lunch!=null) {
				if(StringUtils.isBlank(lunch.getFinalLocation())) {
					return repository.save(newLocation);					
				}
			}
		}
		
		return null;
	 }
	
}
