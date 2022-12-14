package com.deloitte.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.deloitte.model.Tutorial;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class TutorialRepository {
	
	@PersistenceContext // this annotation will directly give object of entity manager without creating obj for emf
	private EntityManager entityManager;
	
	@Transactional
	public Tutorial save(Tutorial tutorial) {
		
		entityManager.persist(tutorial);
		return tutorial;
	}
	
	public Tutorial findById(long id) {
		
		Tutorial tutorial = entityManager.find(Tutorial.class, id);
		return tutorial;
	}
	
	@Transactional
	public Tutorial update(Tutorial tutorial) {
		
		entityManager.merge(tutorial);
		return tutorial;
	}
	
	@Transactional
	public Tutorial deleteById(long id) {
		
		Tutorial tutorial = entityManager.find(Tutorial.class, id);
		if(tutorial!=null)
			entityManager.remove(tutorial);
		return tutorial;
	}
	
	// JPQL written below
	@Transactional
	public int deleteAll() {
		
		Query query = entityManager.createQuery("delete from tutorial");
		return query.executeUpdate();
	}
	
	public List<Tutorial> getAll(){
		
		TypedQuery<Tutorial> query = entityManager.createQuery("select tut from Tutorial tut",Tutorial.class);
		return query.getResultList();
	}
}
