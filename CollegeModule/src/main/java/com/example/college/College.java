package com.example.college;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class College
{
  private Integer id;
  private String name;
  private String location;
public College() {
	super();
}
public College(Integer id, String name, String location) {
	super();
	this.id = id;
	this.name = name;
	this.location = location;
}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
@Override
public String toString() {
	return "College [id=" + id + ", name=" + name + ", location=" + location + "]";
}
  
}