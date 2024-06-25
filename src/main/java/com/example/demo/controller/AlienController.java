package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Alien;
import com.example.demo.repository.AlienRepo;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@GetMapping( path= "/aliens")
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	@GetMapping( "/aliens/{id}")
	public Alien getAlienById(@PathVariable int id) {
		return repo.findById(id).orElse(new Alien(0,""));
	}
	
	@PostMapping( path = "/aliens", consumes= "application/xml")
	public Alien addAlien(@RequestBody Alien alien) {
		return repo.save(alien);
	}
	
	@PutMapping( "/aliens/{id}")
	public Alien updateAlien(@PathVariable int id, @RequestBody Map<String,String> aname) {
		Alien alien = repo.findById(id).get();
		if(alien != null) {
			alien.setAname(aname.get("aname"));
			repo.save(alien);
		}
		
		return alien;
	}

}
