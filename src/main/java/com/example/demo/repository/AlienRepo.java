package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien,Integer>{
	
	List<Alien> findByAname(String aname);

}
