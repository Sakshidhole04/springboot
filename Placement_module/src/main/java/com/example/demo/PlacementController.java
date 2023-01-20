package com.example.demo;

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
public class PlacementController 
{
	@Autowired
	private PlacementService service;
	
	
	// Retrieval operations - Retrieve all rows from database
	
	@GetMapping("/placement")
	public List<Placement>list()
	{
		return service.listAll();
		
	}
	
	
	// Retrieval operations - Retrieve specific record from database

	@GetMapping("/placement/{id}")
	public ResponseEntity<Placement> get(@PathVariable Integer id)
	{
		Placement placement = service.get(id);
		return new ResponseEntity<Placement>(placement,HttpStatus.OK);
		
	}
	
	
	// Create operation - Create a row in database
	
	@PostMapping("/placement")
	public void add(@RequestBody Placement placement)
	{
		service.save(placement);
	}
	
	
	// Update operation - Updating a record in database
	
	@PutMapping("/placement/{id}")
	public ResponseEntity<?>update(@RequestBody Placement placement, @PathVariable Integer id)
	{
		try 
		{
			Placement existplacement = service.get(id);
			service.save(placement);
			return new ResponseEntity<Placement>(placement, HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	// Deletion operation - Deleting a record in database
	
	@DeleteMapping("/placement/{id}")
	public void delete(@PathVariable Integer id)
	{
		service.delete(id);
	}
	
	
	
	
	
	
	
}
