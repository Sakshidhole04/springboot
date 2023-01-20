package com.example.customer;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
@RestController
public class CustomerController
{
 @Autowired
 private CustomerService service;

 // RESTful API methods for Retrieval operations
 @GetMapping("/customer")
 public List<Customer> list()
 {
 return service.listAll();
 }
 @GetMapping("/customer/{id}")
 public ResponseEntity<Customer> get(@PathVariable Integer id)
 {
 try
 {
 Customer customer = service.get(id);
 return new ResponseEntity<Customer>(customer, HttpStatus.OK);
 }
 catch (NoSuchElementException e)
 {
 return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
 }
 }
 // RESTful API method for Create operation
 @PostMapping("/customer")
 public void add(@RequestBody Customer customer)
 {
 service.save(customer);
 }

 // RESTful API method for Update operation
 @PutMapping("/customer/{id}")
 public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Integer id)
 {
 try
 {
Customer existCustomer = service.get(id);
 service.save(customer);
 return new ResponseEntity<>(HttpStatus.OK);
 }
 catch (NoSuchElementException e)
 {
 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }
 }
 // RESTful API method for Delete operation
 @DeleteMapping("/customer/{id}")
 public void delete(@PathVariable Integer id)
 {
 service.delete(id);
 }
}