package br.com.ntk.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class ConnectionFactory {
    private ConnectionFactory() {}
 
    private static EntityManagerFactory entityManagerFactory;
 
    public static EntityManager getEntityManager(){
        if (entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        }
 
        return entityManagerFactory.createEntityManager();
    }
}