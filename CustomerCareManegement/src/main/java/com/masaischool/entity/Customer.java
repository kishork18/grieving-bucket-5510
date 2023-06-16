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
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int customerId;
@Column(length = 20, nullable = false)	
private String name;
@Column(length = 10,nullable = false,unique = true)
private String userName;
@Column(length = 10,nullable = false,unique = true)
private String password;
@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
private List<Issue> list;
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public Customer(String name, String userName, String password, List<Issue> list) {
	super();
	this.name = name;
	this.userName = userName;
	this.password = password;
	this.list = list;
}
public int getCustomerId() {
	return customerId;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<Issue> getList() {
	return list;
}
public void setList(List<Issue> list) {
	this.list = list;
}

}
