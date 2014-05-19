package br.com.vaccine.service.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import br.com.service.bean.FormulaH;
import br.com.service.bean.Logger;
import br.com.service.common.ConnectionFactory;
import br.com.service.dao.HibernateDAO;
import br.com.service.util.TypeFor;



public class ExecutaFormula implements Formula{	

	
	public int processarFormulas(int codProduto,Long numProt ,HibernateDAO dao,int codClasse,TypeFor typeFor) throws Exception {
		List<FormulaH> formulas = null;
		 Connection conn =null;
		 ConnectionFactory cf = new ConnectionFactory();
		
			conn = cf.getConnection();        
            int numUpdate=0;
        try {		
			formulas = loadFormulas(codProduto, numProt, dao,codClasse);
			if(typeFor == TypeFor.CRITICA){
			for (FormulaH f : formulas) {				
				numUpdate+=procItemByForCri(conn, f,numProt);	
				
			   }	
			
			}else {
				for (FormulaH f : formulas) {				
					numUpdate+=procItemByForSug(conn, f,numProt);					
				   }
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			Logger.log("ERRO", e.getMessage());

		} catch (HibernateException e) {
			Logger.log("ERRO", e.getMessage());
		}
		return numUpdate;
		
	}	

	
	public int procItemByForCri(Connection conn, FormulaH bean, Long protocolo) throws Exception {
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		int numUpdate=0;
		boolean booleanSelect = false;
		try {
			
			if (bean.getTxtSql().trim().toLowerCase().startsWith("select")) {
				sb.append("INSERT INTO capreerfp.tb_nfe_critica (NUM_PROT,COD_FORM ");
             
				if (bean.getTxtCol1()!=null)
					//System.out.println(bean.getTxtCol1());
					if (bean.getTxtCol1().trim().length() > 0) {
						sb.append(",TXT_1");
					}
				if (bean.getTxtCol2()!=null)
					//System.out.println(bean.getTxtCol2());
					if (bean.getTxtCol2().trim().length() > 0) {
						sb.append(",TXT_2");
					}
				if (bean.getTxtCol3()!=null)
					//System.out.println(bean.getTxtCol3());
					if (bean.getTxtCol3().trim().length() > 0) {
						sb.append(",TXT_3");
					}
				if (bean.getTxtCol4()!=null)
					//System.out.println(bean.getTxtCol4());
					if (bean.getTxtCol4().trim().length() > 0) {
						sb.append(",TXT_4");
					}
				if(bean.getTxtCol5()!=null)
					//System.out.println(bean.getTxtCol5());
					if (bean.getTxtCol5().trim().length() > 0) {
						sb.append(",TXT_5");
					}
				if (bean.getTxtCol6()!=null)
					//System.out.println(bean.getTxtCol6());
					if (bean.getTxtCol6().trim().length() > 0) {
						sb.append(",TXT_6");
					}
				if (bean.getTxtCol7()!=null)
					//System.out.println(bean.getTxtCol7());
					if (bean.getTxtCol7().trim().length() > 0) {
						sb.append(",TXT_7");
					}
				if (bean.getTxtCol8()!=null)
					//System.out.println(bean.getTxtCol8());
					if (bean.getTxtCol8().trim().length() > 0) {
						sb.append(",TXT_8");
					}
				if (bean.getTxtCol9()!=null)
					//System.out.println(bean.getTxtCol9());
					if (bean.getTxtCol9().trim().length() > 0) {
						sb.append(",TXT_9");
					}
				if (bean.getTxtCol10()!=null)
					//System.out.println(bean.getTxtCol10());
					if (bean.getTxtCol10().trim().length() > 0) {
						sb.append(",TXT_10");
					}
						/*	if (bean.getTxtCol11() != null)
					if (bean.getTxtCol11().trim().length() > 0) {
						sb.append(",TXT_11");
					}
				if (bean.getTxtCol12() != null)
					if (bean.getTxtCol12().trim().length() > 0) {
						sb.append(",TXT_12");
					}
				if (bean.getTxtCol13() != null)
					if (bean.getTxtCol13().trim().length() > 0) {
						sb.append(",TXT_13");
					}
				if (bean.getTxtCol14() != null)
					if (bean.getTxtCol14().trim().length() > 0) {
						sb.append(",TXT_14");
					}
				if (bean.getTxtCol15() != null)
					if (bean.getTxtCol15().trim().length() > 0) {
						sb.append(",TXT_15");
					}*/
				sb.append(") select ?, ? , " + bean.getTxtSql().replaceFirst("select", "").replace("${num_prot}", String.valueOf(protocolo)));
				booleanSelect = true;
			  
			} else {
				sb.append(bean.getTxtSql().replace("${num_prot}", String.valueOf(protocolo)));
			}
		    conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sb.toString());
			
			if (booleanSelect) {				
				pstmt.setLong(1, protocolo);
				pstmt.setFloat(2, bean.getCodFormula());
				
			}
			numUpdate=pstmt.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
			pstmt.close();
			//conn.close();
            sb=null;
            
            
		} catch (NullPointerException e) {
			pstmt.close();
			sb=null;
			Logger.log("ERRO ", e.getMessage() + " COD_FORMULA " + bean.getCodFormula());
			throw new SQLException(e.getMessage() + " COD_FORMULA " + bean.getCodFormula());
			
		} catch (SQLException e) {
			pstmt.close();
			sb=null;
			Logger.log("ERRO sugestao", e.getMessage() + " COD_FORMULA " + bean.getCodFormula());
			throw new SQLException("ERRO Formula sugestao COD_FORMULA " + bean.getCodFormula());
			

		}
		return numUpdate;
	}
	
	
	public int procItemByForSug(Connection conn, FormulaH bean, Long protocolo) throws Exception {
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		int numUpdate=0;
		boolean booleanSelect = false;

		try {
		
			if (bean.getTxtSql().trim().toLowerCase().startsWith("select")) {

				sb.append("INSERT INTO capreerfp.tb_nfe_sugestao (NUM_PROT,COD_FORM ");
				if (bean.getTxtCol1()!=null)
					//System.out.println(bean.getTxtCol1());
					if (bean.getTxtCol1().trim().length() > 0) {
						sb.append(",TXT_1");
					}
				if (bean.getTxtCol2()!=null)
					//System.out.println(bean.getTxtCol2());
					if (bean.getTxtCol2().trim().length() > 0) {
						sb.append(",TXT_2");
					}
				if (bean.getTxtCol3()!=null)
					//System.out.println(bean.getTxtCol3());
					if (bean.getTxtCol3().trim().length() > 0) {
						sb.append(",TXT_3");
					}
				if (bean.getTxtCol4()!=null)
					//System.out.println(bean.getTxtCol4());
					if (bean.getTxtCol4().trim().length() > 0) {
						sb.append(",TXT_4");
					}
				if(bean.getTxtCol5()!=null)
					//System.out.println(bean.getTxtCol5());
					if (bean.getTxtCol5().trim().length() > 0) {
						sb.append(",TXT_5");
					}
				if (bean.getTxtCol6()!=null)
					System.out.println(bean.getTxtCol6());
					if (bean.getTxtCol6().trim().length() > 0) {
						sb.append(",TXT_6");
					}
				if (bean.getTxtCol7()!=null)
					//System.out.println(bean.getTxtCol7());
					if (bean.getTxtCol7().trim().length() > 0) {
						sb.append(",TXT_7");
					}
				if (bean.getTxtCol8()!=null)
					//System.out.println(bean.getTxtCol8());
					if (bean.getTxtCol8().trim().length() > 0) {
						sb.append(",TXT_8");
					}
				if (bean.getTxtCol9()!=null)
					//System.out.println(bean.getTxtCol9());
					if (bean.getTxtCol9().trim().length() > 0) {
						sb.append(",TXT_9");
					}
				if (bean.getTxtCol10()!=null)
					//System.out.println(bean.getTxtCol10());
					if (bean.getTxtCol10().trim().length() > 0) {
						sb.append(",TXT_10");
					}
							/*if (bean.getTxtCol11() != null)
					if (bean.getTxtCol11().trim().length() > 0) {
						sb.append(",TXT_11");
					}
				if (bean.getTxtCol12() != null)
					if (bean.getTxtCol12().trim().length() > 0) {
						sb.append(",TXT_12");
					}
				if (bean.getTxtCol13() != null)
					if (bean.getTxtCol13().trim().length() > 0) {
						sb.append(",TXT_13");
					}
				if (bean.getTxtCol14() != null)
					if (bean.getTxtCol14().trim().length() > 0) {
						sb.append(",TXT_14");
					}
				if (bean.getTxtCol15() != null)
					if (bean.getTxtCol15().trim().length() > 0) {
						sb.append(",TXT_15");
					}*/
				sb.append(") select ?, ? , " + bean.getTxtSql().replaceFirst("select", "").replace("${num_prot}", String.valueOf(protocolo)));
				booleanSelect = true;
			 
			} else {
				sb.append(bean.getTxtSql().replace("${num_prot}", String.valueOf(protocolo)));
			}
		    conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sb.toString());
			
			if (booleanSelect) {				
				pstmt.setLong(1, protocolo);
				pstmt.setFloat(2, bean.getCodFormula());
				
			}
			//System.out.println(pstmt.getWarnings());
			//System.out.println("GRAVANDO  SUGESTAO "+protocolo+"  "+pstmt.toString());
			numUpdate=pstmt.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
			pstmt.close();
			conn.close();
            sb=null;
            
		} catch (NullPointerException e) {
			pstmt.close();
			sb=null;
			Logger.log("ERRO sugestao", e.getMessage() + " COD_FORMULA " + bean.getCodFormula());
			throw new SQLException(e.getMessage() + " COD_FORMULA " + bean.getCodFormula());
			

		} catch (SQLException e) {
			pstmt.close();
			sb=null;
			Logger.log("ERRO sugestao", e.getMessage() + " COD_FORMULA " + bean.getCodFormula());
			throw new SQLException("ERRO Formula sugestao COD_FORMULA " + bean.getCodFormula());
			

		}
		return numUpdate;
	}


	@Override
	public List<FormulaH> loadFormulas(int codProduto, Long numProt, HibernateDAO dao, int codClasse) {
		return dao.getFormulaByProduto(codProduto,codClasse);
	}

}
