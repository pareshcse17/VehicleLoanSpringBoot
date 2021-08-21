package com.example.demo.layer3;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class BaseRepository {
	@PersistenceContext
	public EntityManager entityManager;

	
	public EntityManager getEntityManager() {
		System.out.println("BaseRepository: getting entity manager...");
		return entityManager;
	}
}
