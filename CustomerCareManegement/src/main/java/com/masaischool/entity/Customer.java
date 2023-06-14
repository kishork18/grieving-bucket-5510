package com.masaischool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
	
}
