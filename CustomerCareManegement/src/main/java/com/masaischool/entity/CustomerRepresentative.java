package com.masaischool.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerRepresentative {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int rePresentativeId;
  private String name;
  private String username;
  private String password;
}
