package com.masaischool.dao;

import java.util.List;

import com.masaischool.entity.Customer;
import com.masaischool.entity.CustomerRepresentative;
import com.masaischool.entity.Issue;
import com.masaischool.exceptions.RecordNotFondException;
import com.masaischool.exceptions.SomthingWentWrongException;
import com.masaischool.utility.DBUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public String addCR(CustomerRepresentative cr) throws SomthingWentWrongException {
		// TODO Auto-generated method stub
	    EntityManager em=null;
	    EntityTransaction et=null;
		try {
			em=DBUtils.createConnection();
			Query q=em.createQuery("SELECT count(c) FROM CustomerRepresentative c WHERE username=:id");
			q.setParameter("id", cr.getUsername());
			if((Long)q.getSingleResult() > 0) {
				throw  new SomthingWentWrongException("CustomerRepresentative allready Exist");
			}
			et=em.getTransaction();
			et.begin();
			em.persist(cr);
			et.commit();
			return "Customer Representative added successfully.";
		} catch (PersistenceException e) {
			// TODO: handle exception 
			et.rollback();
			throw  new SomthingWentWrongException("Somthing went wrong.");
		}
		finally {
			em.close();
		}
		
	}

	@Override
	public CustomerRepresentative findCR(String username) throws SomthingWentWrongException, RecordNotFondException {
		EntityManager em=null;
		List<CustomerRepresentative> CRlist=null;
		try {
			em=DBUtils.createConnection();
			Query q=em.createQuery("FROM CustomerRepresentative c WHERE username=:username");
			q.setParameter("username", username);
			CRlist=(List<CustomerRepresentative>)q.getResultList();
			if(CRlist.size()==0) {
				throw new RecordNotFondException("Record Not fond");
			}
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			throw new SomthingWentWrongException("Somthing went Wrong please try again.");
		}
		finally {
			em.close();
		}
		return CRlist.get(0);
	}

	@Override
	public List<CustomerRepresentative> allCR() throws RecordNotFondException, SomthingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em=null;
		List<CustomerRepresentative> crList=null;
		try {
			em=DBUtils.createConnection();
			Query q=em.createQuery("From CustomerRepresentative c");
			crList=(List<CustomerRepresentative>)q.getResultList();
			if(crList.size()==0) {
				throw new RecordNotFondException("No Representative fond");
			}
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			throw new SomthingWentWrongException("Somthing went wrong");
		}
		finally {
			em.close();
		}
		return crList;
	}

	@Override
	public void deleteCR(CustomerRepresentative cr) throws RecordNotFondException, SomthingWentWrongException {
		// TODO Auto-generated method stub
		try(EntityManager em=DBUtils.createConnection()){
			CustomerRepresentative cr1=em.find(CustomerRepresentative.class, cr);
			if(cr1==null) {
				throw new RecordNotFondException("Record Not found");
			}
			EntityTransaction et=em.getTransaction();
			et.begin();
			cr1.setDeleted(true);
			et.commit();
		}catch (PersistenceException e) {
			// TODO: handle exception
			throw new SomthingWentWrongException("Somthing went wrong");
		}
	
	}

	@Override
	public List<Customer> viewAllCustomer() throws RecordNotFondException, SomthingWentWrongException {
		// TODO Auto-generated method stub
		List<Customer> list=null;
		try(EntityManager em=DBUtils.createConnection()){
			Query q=em.createQuery("from customer c");
		     list=(List<Customer>)q.getResultList();
		     if(list.size()==0) {
		    	 throw new RecordNotFondException("No record Found");
		     }
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
			throw new SomthingWentWrongException("Somthing went wrong");
		}
		return list;
		
	}

	@Override
	public List<Issue> viewAllIssue() throws RecordNotFondException, SomthingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCR(CustomerRepresentative cr) throws SomthingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
