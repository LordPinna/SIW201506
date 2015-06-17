package it.siw.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("siw-unit");
		EntityManager em = emf.createEntityManager();
		//Product p = new Product("Pere", 1F, 10, "1234");
		//Provider pr = em.find(Provider.class, "Prova");
		em.close();
		emf.close();

	}

}
