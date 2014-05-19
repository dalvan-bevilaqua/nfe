package br.com.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.service.bean.Acesso;
import br.com.service.bean.Cliente;
import br.com.service.bean.CriticaTO;
import br.com.service.bean.FormulaH;
import br.com.service.bean.Logger;
import br.com.service.bean.SugestaoTO;
import br.com.service.common.ConnectionFactory;
import br.com.service.util.Perfil;


public class JdbcDAO {

	public List<FormulaH> getFormulaByProdutoJDBC(int codProduto) {
		List<FormulaH> formulas=null;
		FormulaH f=null;
		Connection conn = null;
		
		String sql="SELECT * FROM capreerfp.tb_sys_formula where cod_produto=?";
		
		
		try {
			ConnectionFactory cf = new ConnectionFactory();
			conn = cf.getConnection();
			
			PreparedStatement pstm =conn.prepareStatement(sql);
			pstm.setLong(1, codProduto);
	        ResultSet rs=pstm.executeQuery();
	        formulas = new ArrayList<FormulaH>();
	        while(rs.next()){
	        	
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		if(formulas.isEmpty())
			Collections.emptyList();	
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return Collections.unmodifiableList(formulas);
		
	
	}

	public List<Cliente> clientesByContrato(int codContrato,int perfil) throws SQLException {
		List<Cliente> clientes = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			ConnectionFactory cf = new ConnectionFactory();
			conn = cf.getConnection();
			if (perfil == Perfil.MASTER.ordinal()) {
				pstm = conn.prepareStatement("select a.cod_contrato_cnpj,a.cnpj from tb_sys_contrato_cnpj a");
				
			}else if(perfil == 2){ 
				pstm = conn.prepareStatement("select a.cod_contrato_cnpj,a.cnpj from tb_sys_contrato_cnpj a inner join tb_sys_contrato b on a.cod_contrato=b.cod_contrato where a.cod_contrato="+codContrato);
			
			}else if(perfil == 4){
				pstm = conn.prepareStatement("select a.cod_contrato_cnpj,a.cnpj from capreerfp.tb_sys_contrato_cnpj a "+
											"	inner join capreerfp.tb_sys_contrato b on a.cod_contrato=b.cod_contrato "+
											"	inner join capreerfp.tb_sys_login_cnpj_acesso c on a.cod_contrato_cnpj=c.cod_contrato_cnpj"+
											"	where a.cod_contrato="+codContrato);
		
			}
			System.out.println("JdbcDAO.clientesByContrato(int codContrato) "+pstm.toString());
			
			ResultSet rs = pstm.executeQuery();
			clientes = new ArrayList<Cliente>();
			
			
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setCodContratoCnpj(rs.getInt("cod_contrato_cnpj"));
				c.setCnpj(rs.getString("cnpj"));
				clientes.add(c);
			}
			
		} catch (SQLException e) {
			Logger.log("ERRO " + getClass(), e.getMessage());
			e.printStackTrace();
		}
		conn.close();
		return clientes;

	}
	
	public List<CriticaTO> getReview(Long numProt) throws SQLException{
		List<CriticaTO> objetos=null;
		CriticaTO objeto=null;	
		String sql="SELECT f.nom_formula,f.txt_legal,f.TXT_col1,f.TXT_col2,f.TXT_col3,f.TXT_col4, "
				+ "f.TXT_col5,f.TXT_col6,f.TXT_col7,f.TXT_col8,f.TXT_col9,f.TXT_col10,f.TXT_col11, "
				+ "f.TXT_col12,f.TXT_col13,f.TXT_col14,f.TXT_col15,"
				+ "c.txt_1,c.txt_2,c.txt_3,c.txt_4,c.txt_5,c.txt_6,c.txt_7,c.txt_8,c.txt_9,c.txt_10 " 
				+ "FROM capreerfp.tb_nfe_critica c inner join capreerfp.tb_sys_formula f "
		        + "on f.cod_formula=c.cod_form where c.num_prot=?; ";		
		
		Connection conn = null;
		
		try {
			ConnectionFactory cf = new ConnectionFactory();
			conn = cf.getConnection();
			PreparedStatement pstm =conn.prepareStatement(sql);
			pstm.setLong(1, numProt);
            ResultSet rs=pstm.executeQuery();
            objetos = new ArrayList<CriticaTO>();
            while(rs.next()){
            	objeto= new CriticaTO();    
            	
            	objeto.setNomFormula(rs.getString("nom_formula"));
            	objeto.setTxtLegal(rs.getString("txt_legal"));
            	objeto.setTxtFor1(rs.getString("TXT_col1"));
            	objeto.setTxtFor2(rs.getString("TXT_col2"));
            	objeto.setTxtFor3(rs.getString("TXT_col3"));
            	objeto.setTxtFor4(rs.getString("TXT_col4"));
            	objeto.setTxtFor5(rs.getString("TXT_col5"));
            	objeto.setTxtFor6(rs.getString("TXT_col6"));
            	objeto.setTxtFor7(rs.getString("TXT_col7"));
            	objeto.setTxtFor8(rs.getString("TXT_col8"));
            	objeto.setTxtFor9(rs.getString("TXT_col9"));
            	objeto.setTxtFor10(rs.getString("TXT_col10"));            	
            	objeto.setTxtFor11(rs.getString("TXT_col11"));
            	objeto.setTxtFor12(rs.getString("TXT_col12"));
            	objeto.setTxtFor13(rs.getString("TXT_col13"));
            	objeto.setTxtFor14(rs.getString("TXT_col14"));
            	objeto.setTxtFor15(rs.getString("TXT_col15")); 
            	
            	objeto.setTxtCri1(rs.getString("TXT_1"));
            	objeto.setTxtCri2(rs.getString("TXT_2"));
            	objeto.setTxtCri3(rs.getString("TXT_3"));
            	objeto.setTxtCri4(rs.getString("TXT_4"));
            	objeto.setTxtCri5(rs.getString("TXT_5"));
            	objeto.setTxtCri6(rs.getString("TXT_6"));
            	objeto.setTxtCri7(rs.getString("TXT_7"));
            	objeto.setTxtCri8(rs.getString("TXT_8"));
            	objeto.setTxtCri9(rs.getString("TXT_9"));  
            	objeto.setTxtCri10(rs.getString("TXT_10"));         	
            	
            	
            	//objeto.setNomFormula(rs.getString(1));
            	objetos.add(objeto);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn.close();
		return objetos;
	}
	
	
	public List<SugestaoTO> getSuggestions(Long numProt) throws SQLException{
		List<SugestaoTO> objetos=null;
		SugestaoTO objeto=null;	
		String sql="SELECT f.nom_formula,f.txt_legal,f.TXT_col1,f.TXT_col2,f.TXT_col3,f.TXT_col4, "
				+ "f.TXT_col5,f.TXT_col6,f.TXT_col7,f.TXT_col8,f.TXT_col9,f.TXT_col10,f.TXT_col11, "
				+ "f.TXT_col12,f.TXT_col13,f.TXT_col14,f.TXT_col15,"
				+ "c.txt_1,c.txt_2,c.txt_3,c.txt_4,c.txt_5,c.txt_6,c.txt_7,c.txt_8,c.txt_9,c.txt_10 " 
				+ "FROM capreerfp.tb_nfe_sugestao c inner join capreerfp.tb_sys_formula f "
		        + "on f.cod_formula=c.cod_form where c.num_prot=?;";	
		
		Connection conn = null;
		
		try {
			ConnectionFactory cf = new ConnectionFactory();
			conn = cf.getConnection();
			PreparedStatement pstm =conn.prepareStatement(sql);
			pstm.setLong(1, numProt);
            ResultSet rs=pstm.executeQuery();
            objetos = new ArrayList<SugestaoTO>();
            while(rs.next()){
            	objeto= new SugestaoTO();    
            	
            	objeto.setNomFormula(rs.getString("nom_formula"));
            	objeto.setTxtLegal(rs.getString("txt_legal"));
            	objeto.setTxtFor1(rs.getString("TXT_col1"));
            	objeto.setTxtFor2(rs.getString("TXT_col2"));
            	objeto.setTxtFor3(rs.getString("TXT_col3"));
            	objeto.setTxtFor4(rs.getString("TXT_col4"));
            	objeto.setTxtFor5(rs.getString("TXT_col5"));
            	objeto.setTxtFor6(rs.getString("TXT_col6"));
            	objeto.setTxtFor7(rs.getString("TXT_col7"));
            	objeto.setTxtFor8(rs.getString("TXT_col8"));
            	objeto.setTxtFor9(rs.getString("TXT_col9"));
            	objeto.setTxtFor10(rs.getString("TXT_col10"));            	
            	objeto.setTxtFor11(rs.getString("TXT_col11"));
            	objeto.setTxtFor12(rs.getString("TXT_col12"));
            	objeto.setTxtFor13(rs.getString("TXT_col13"));
            	objeto.setTxtFor14(rs.getString("TXT_col14"));
            	objeto.setTxtFor15(rs.getString("TXT_col15")); 
            	
            	objeto.setTxtCri1(rs.getString("TXT_1"));
            	objeto.setTxtCri2(rs.getString("TXT_2"));
            	objeto.setTxtCri3(rs.getString("TXT_3"));
            	objeto.setTxtCri4(rs.getString("TXT_4"));
            	objeto.setTxtCri5(rs.getString("TXT_5"));
            	objeto.setTxtCri6(rs.getString("TXT_6"));
            	objeto.setTxtCri7(rs.getString("TXT_7"));
            	objeto.setTxtCri8(rs.getString("TXT_8"));
            	objeto.setTxtCri9(rs.getString("TXT_9"));  
            	objeto.setTxtCri10(rs.getString("TXT_10"));         	
            	
            	objetos.add(objeto);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn.close();
		return objetos;
	}
	
	
	public Acesso userWithAccess(int codContrato,int codLogin)throws SQLException {
		
		Connection conn = null;		
		Acesso acesso=null;
		String sql="select * from tb_sys_contrato_cnpj a inner join capreerfp.tb_sys_login_cnpj_acesso b "+ 
		"on a.cod_contrato_cnpj=b.cod_contrato_cnpj inner join tb_sys_login c on a.cod_contrato=c.cod_contrato "+
		"where a.cod_contrato=? and b.cod_login=? group by b.cod_contrato_cnpj";		
		
		
		try {
			ConnectionFactory cf = new ConnectionFactory();
			conn = cf.getConnection();			
			PreparedStatement pstm =conn.prepareStatement(sql);
			pstm.setInt(1, codContrato);
			pstm.setInt(2, codLogin);
			//System.out.println("JdBcDAO.userWithAccess(int codContrato,int codLogin) "+pstm.toString());
			ResultSet rs=pstm.executeQuery();			
			if(rs.next())
			acesso = new Acesso();
			acesso.setCnpj(rs.getString("cnpj"));
			acesso.setCodContrCnpjTipo(rs.getInt("COD_CONTRATO_CNPJ_TIPO"));
			acesso.setPerfil(rs.getInt("COD_PERFIL"));
			
		} catch (SQLException e) {
			Logger.log("ERRO [userWithAccess]"+getClass(), e.getMessage());
			throw e;
		}finally{
			conn=null;
			//cf=null;
		}
		return acesso;			

	}
	
	
		
}
