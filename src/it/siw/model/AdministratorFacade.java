package it.siw.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AdministratorFacade {

	private EntityManagerFactory emf;
	private EntityManager em;

	public AdministratorFacade(){
		this.emf = Persistence.createEntityManagerFactory("siw-unit");
		this.em = emf.createEntityManager();
	}

	public Administrator getAdministrator(String username, String password){
		Query q = em.createQuery("SELECT a FROM Administrator a WHERE a.username=:username AND a.password=:password");
		q.setParameter("username", username);
		q.setParameter("password", password);
		Administrator administrator = null;
		try{
			administrator = (Administrator) q.getSingleResult();
		} catch (Exception NoResult){
			administrator = null;
		}
		em.close();
		emf.close();
		return administrator;
	}


}
