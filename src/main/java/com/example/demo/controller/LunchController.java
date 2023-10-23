package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Lunch;
import com.example.demo.exception.LunchNotFoundException;
import com.example.demo.repository.LunchRepository;

@RestController
public class LunchController {
	
	@Autowired
	private LunchRepository repository;
	
	public LunchController(LunchRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/lunch/{id}")
	 public Lunch one(@PathVariable Long id) {
	    
		Lunch lunch = repository.findByLunchId(id);
		if(lunch == null) return new Lunch();
		else return lunch;
		
//		return repository.findById(id).orElseThrow(() -> new LunchNotFoundException(id));
	 }
	
	@PostMapping("/lunch/addParty")
	 public Lunch add(@RequestBody Lunch newLunch) { 
	    return repository.save(newLunch);
	 }
	
	@PostMapping("/lunch/updateParty")
	 public Lunch update(@RequestBody Lunch newLunch) {
		
		Lunch lunch = repository.findByLunchId(newLunch.getLunchId());
		lunch.setFinalLocation(newLunch.getFinalLocation());
		lunch.setPasscode(newLunch.getPasscode());
		
	    return repository.save(lunch);
	 }
	
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}
