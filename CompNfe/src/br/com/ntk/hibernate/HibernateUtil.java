package br.com.ntk.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.com.service.bean.Logger;
//import br.com.service.common.Comuns;
import br.com.service.common.Comuns;

	public class HibernateUtil {
		private static SessionFactory factory;   
	      
	        static {	        	
	        	try{       
	        		    			
	        	Configuration cfg = new Configuration();
	        	cfg.configure("/hibernate.cfg.xml");	        	
	        	
	        	try{
	        	cfg.setProperty("hibernate.connection.password",Comuns.setupProperties().getProperty("database.pwd"));
	        	cfg.setProperty("hibernate.connection.username",Comuns.setupProperties().getProperty("database.usr"));
	        	//cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	        	//cfg.setProperty("hibernate.connection.url", Comuns.setupProperties().getProperty("database.url"));
	        	//cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    	        // etc, etc, for all properties
    	        //cfg.setProperties(cfg.getProperties());               
	        	}catch(Exception e){
	        		e.printStackTrace();
	        	}
	            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	           
	             factory = cfg.buildSessionFactory(serviceRegistry);   
	             if(factory==null){	            	 
	            	 Logger.log("FALHA ","conexao nao foi criada  hibernate util "+cfg.getProperties());
	             }
	        	}catch(HibernateException exc){
	        		Logger.log("ERRO ",exc.getMessage()+"  hibernate util "+factory);
	        		System.out.println("package br.com.ntk.hibernate.HibernateUtil "+exc.getMessage());
	        	}catch (Exception e) {	        		
	        		Logger.log("ERRO ",e.getMessage()+"  HibernateUtil.SessionFactory.factory");
	        		System.out.println("package br.com.ntk.hibernate.HibernateUtil "+e.getMessage());
	        		
	    		}
	      
	        }  
	          
	        public static Session getSession() {	        	
	            return factory.openSession();         	
	        	
	        }  

	}  
	      
	