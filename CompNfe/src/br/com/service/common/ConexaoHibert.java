package br.com.service.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ConexaoHibert {

	
	private final static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.hibernate.vaccine.jpa");
	
	
	public static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	protected void setUp() throws Exception {
		EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.vaccine.jpa" );
	}
	
	
}
