package com.masaischool.dao;

import java.util.List;

import com.masaischool.entity.Customer;
import com.masaischool.entity.CustomerRepresentative;
import com.masaischool.entity.Issue;
import com.masaischool.exceptions.RecordNotFondException;
import com.masaischool.exceptions.SomthingWentWrongException;

public interface AdminDAO {
  public String addCR(CustomerRepresentative cr)throws SomthingWentWrongException;
  public CustomerRepresentative findCR(String username)throws SomthingWentWrongException,RecordNotFondException;
  public String updateCR(CustomerRepresentative cr)throws SomthingWentWrongException;
  public List<CustomerRepresentative> allCR()throws RecordNotFondException,SomthingWentWrongException;
  public void deleteCR(CustomerRepresentative cr)throws RecordNotFondException,SomthingWentWrongException;
  public List<Customer> viewAllCustomer()throws RecordNotFondException,SomthingWentWrongException;
  public List<Issue> viewAllIssue()throws RecordNotFondException,SomthingWentWrongException;
}
