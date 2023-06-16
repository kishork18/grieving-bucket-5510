package com.masaischool.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CustomerRepresentative {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int rePresentativeId;
  @Column(nullable = false, length=50)
  private String name;
  @Column(length=10,nullable = false,unique = true)
  private String username;
  @Column(length=10,nullable = false,unique = true)
  private String password;
  @Column(nullable = false)
  private boolean isDeleted=false;
  @OneToMany(mappedBy = "represntative",cascade = CascadeType.ALL)
  List<Issue> allIssue;
public CustomerRepresentative() {
	super();
	// TODO Auto-generated constructor stub
}
public CustomerRepresentative(String name, String username, String password, List<Issue> allIssue) {
	super();
	this.name = name;
	this.username = username;
	this.password = password;
	this.allIssue = allIssue;
}
public boolean isDeleted() {
	return isDeleted;
}
public void setDeleted(boolean isDeleted) {
	this.isDeleted = isDeleted;
}
public int getRePresentativeId() {
	return rePresentativeId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<Issue> getAllIssue() {
	return allIssue;
}
public void setAllIssue(List<Issue> allIssue) {
	this.allIssue = allIssue;
}
  
}
