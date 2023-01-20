package com.example.college;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CollegeService {
	
	@Autowired
	private CollegeRepository repository;
	
	// Retrieving rows
	public List<College> listAll() 
	{
		return repository.findAll();
	}
	
	// Retrieving specific row
	public College get(Integer id) 
	{
		return repository.findById(id).get();
	}
	
	
	// Adding row
	public void save(College college)
	{
		repository.save(college);
	}

	public void delete(Integer id) 
	{
		repository.deleteById(id);
	}

}

