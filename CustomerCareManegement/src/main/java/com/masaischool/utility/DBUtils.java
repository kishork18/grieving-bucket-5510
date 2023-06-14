package com.masaischool.utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBUtils {
  static EntityManagerFactory emf=null;
  static {
	  emf=Persistence.createEntityManagerFactory("CWconnect");
  }
  public static EntityManager createConnection() {
	  return emf.createEntityManager();
  }
}
