package com.example.college;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollegeController 
{
	@Autowired
	private CollegeService service;
	
	
	// Retrieval operations - Retrieve all rows from database
	
	@GetMapping("/college")
	public List<College>list()
	{
		return service.listAll();
		
	}
	
	
	// Retrieval operations - Retrieve specific record from database

	@GetMapping("/college/{id}")
	public ResponseEntity<College> get(@PathVariable Integer id)
	{
		College college = service.get(id);
		return new ResponseEntity<College>(college,HttpStatus.OK);
		
	}
	
	
	// Create operation - Create a row in database
	
	@PostMapping("/college")
	public void add(@RequestBody College college)
	{
		service.save(college);
	}
	
	
	// Update operation - Updating a record in database
	
	@PutMapping("/college/{id}")
	public ResponseEntity<?>update(@RequestBody College college, @PathVariable Integer id)
	{
		try 
		{
			College existcollege = service.get(id);
			service.save(college);
			return new ResponseEntity<College>(college, HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	// Deletion operation - Deleting a record in database
	
	@DeleteMapping("/college/{id}")
	public void delete(@PathVariable Integer id)
	{
		service.delete(id);
	}
	
	
	
	
	
	
	
}

