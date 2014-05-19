package br.com.service.dao;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.ntk.hibernate.HibernateUtil;
import br.com.service.bean.Cliente;
import br.com.service.bean.Contrato;
import br.com.service.bean.FormulaH;
import br.com.service.bean.Logger;
import br.com.service.bean.Login;

public class HibernateDAO implements ClienteDAO{

	@Override
	public Login consultaUsuario(String email ,String senha) {
		Criteria criteria =null;
		Session session=null;		
		session=HibernateUtil.getSession(); 
		try{
			if(session!=null){
		 
		     criteria =session.createCriteria(Login.class);
			}else{
				System.out.println("sem conexão hibernate");
			}
				
		 
		}catch(Exception e){
			Logger.log("ERRO HibernateDAO.consultaUsuario(String email ,String senha)"+getClass(), e.getMessage());
		}/*finally{       
	       	session.close();	        	
	        
	        }	*/	
		criteria.add(Restrictions.eq("eMail", email));
		criteria.add(Restrictions.eq("senha", senha));
		
        Login l = (Login) criteria.uniqueResult();	
	    return l;
		
	
	}

		@Override
		public Login consultaUsuario(String email) {
			Criteria criteria =null;
			Session session=null;		
			
			try{
				session=HibernateUtil.getSession(); 
			 criteria =session.createCriteria(Login.class);			 
			}catch(Exception e){
				Logger.log("ERRO HibernateDAO.consultaUsuario(String email)"+getClass(), e.getMessage());
			}
			criteria.add(Restrictions.eq("eMail", email));
			
	        Login l = (Login) criteria.uniqueResult();	
		    return l;
			
		
		}

	@Override
	public boolean autentica(Serializable pojo) {
		// TODO Auto-generated method stub
		return false;
	}	
	
	@Override
	public Contrato consultaCliByCont(int codContrato) {
		Criteria criteria =null;
		Session session=null;		
		 
		try{
			session=HibernateUtil.getSession();
		 criteria =session.createCriteria(Login.class);
		}catch(Exception e){
			Logger.log("ERRO "+getClass(), e.getMessage());
		}finally{       
	       	session.close();	        	
	        
	        }		
		criteria.add(Restrictions.eq("codContrato", codContrato));
		
		Contrato c = (Contrato) criteria.uniqueResult();		
		//List<Cliente> clientes = c.getClientes();		
		//System.out.println(clientes.size()); 
	    return c;
		
	}

	@Override
	public List<Cliente> contratosByCliente(int codContrato) {
		Criteria criteria =null;
		Session session=null;		
		
		//List<Cliente> clientes=null;
		try{
			session=HibernateUtil.getSession();
		 criteria =session.createCriteria(Contrato.class);
		}catch(Exception e){
			Logger.log("ERRO "+getClass(), e.getMessage());
		}finally{       
	       	session.close();	        	
	        
	        }		
		criteria.add(Restrictions.eq("codContrato", codContrato));
		
		Contrato c =(Contrato) criteria.uniqueResult();
		//clientes=c.getClientes();
		//System.out.println(clientes.size());
		
	    return c.getClientes();
		
	}
	
	public boolean persistDao(Serializable pojo) throws Exception {    	
    	Session session=null; 
    	boolean save=false;
        try {     	
        	       	 
        	session=HibernateUtil.getSession();        	
    		session.beginTransaction();    		
    		session.save(pojo);    		
    		session.getTransaction().commit();  
    		save=true;
    		
        }catch (HibernateException e) {        	
        	session.getTransaction().rollback();
        	session.close();        	
			e.printStackTrace();
			
		} catch (Exception e) {			
			session.getTransaction().rollback();
			session.close();
        	
        }finally{       
       	session.close();
        pojo=null;	
        
        }
		return save;
		
    }
	
	public List<FormulaH> getFormulaByProduto(int codProduto,int codClasse) {
		Session session=null;		
		List<FormulaH> formulas=null;
		 
		try{
			session=HibernateUtil.getSession();
		Criteria criteria =session.createCriteria(FormulaH.class);
		criteria.add(Restrictions.eq("codProduto", codProduto));
		criteria.add(Restrictions.eq("codClasse",codClasse));
		criteria.add(Restrictions.eq("statusFormula","S"));
		
		formulas = criteria.list();
		}catch(HibernateException e){
			System.out.println(e.getMessage());
		}finally{       
	       	session.close();	        	
	        
	        }
		if(formulas.isEmpty())
			Collections.emptyList();	
	
	   return Collections.unmodifiableList(formulas);
		
	
	}
	
	
	
}
