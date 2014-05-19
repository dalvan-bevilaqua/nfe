package br.com.ntk.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public enum JPAUtil {
 
    INSTANCE;
 
    private EntityManagerFactory emf;
 
    JPAUtil() {
        emf = Persistence.createEntityManagerFactory("vaccine-ds");
    }
 
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}