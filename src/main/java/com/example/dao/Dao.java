package com.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Dao {
	

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void save(Object obj)
	{
		//System.out.println("Saving to db"+em.getProperties());
	
		//em.getTransaction().begin();
		
		
		em.persist(obj);
		//em.flush();
		//em.getTransaction().commit();
	//	em.close();
		
	}
}
