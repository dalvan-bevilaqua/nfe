package br.com.vaccine.service.controller;

import java.sql.Connection;
import java.util.List;

import br.com.service.bean.FormulaH;
import br.com.service.dao.HibernateDAO;
import br.com.service.util.TypeFor;

public interface Formula {
	
	 List<FormulaH> loadFormulas(int codProduto, Long numProt, HibernateDAO dao,int codClasse);
	 int processarFormulas(int codProduto,Long numProt ,HibernateDAO dao,int codClasse,TypeFor typeFor) throws Exception ;
     int procItemByForCri(Connection conn, FormulaH bean, Long protocolo) throws Exception ;
     int procItemByForSug(Connection conn, FormulaH bean, Long protocolo) throws Exception ;



}
