package it.beije.pascal.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import it.beije.pascal.model.Contatto;

@Service
public class RubricaDBService {
	
	public List<Contatto> getList(){
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PascalSpring");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Contatto as c");
		contatti = query.getResultList();
		
		return contatti;
	}
}
