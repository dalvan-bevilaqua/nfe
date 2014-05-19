package br.com.service.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import br.com.service.bean.Logger;


public class ConnectionFactory {
	
	public PreparedStatement pstmt = null;
	public Connection cnn = null;
	
	public  Connection getConnection()  throws SQLException{
		try{
			Properties prop = Comuns.setupProperties();
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(prop.getProperty("database.url") ,prop.getProperty("database.usr"),prop.getProperty("database.pwd"));
		
		}catch(ClassNotFoundException e){
			//emailNotificacaoAcessoDados(null);
			Logger.log("ERRO", e.getMessage());
			throw new SQLException(e.getMessage());
		}catch(Exception e){
			//emailNotificacaoAcessoDados(null);
			Logger.log("ERRO", e.getMessage());
			throw new SQLException("[ConnectionFactory:getConnection]" + e.getMessage());
		}
	}
	
	
	public void openStatement(Connection paramCnn, String query) throws SQLException{
		this.pstmt = paramCnn.prepareStatement(query);
	}
	
	public void openStatementReturnId(Connection paramCnn, String query) throws SQLException{
		this.pstmt = paramCnn.prepareStatement(query,pstmt.RETURN_GENERATED_KEYS);
	}
	
	public void openCallStatement(Connection paramCnn, String query) throws SQLException{
		this.pstmt = paramCnn.prepareCall(query);
	}
	
	public void closeStatement() throws SQLException{
		try{this.pstmt.clearParameters();}catch(Exception ex){}
		try{this.pstmt.close();this.pstmt = null;}catch(Exception ex){}
		try{this.cnn.close();}catch(Exception ex){}
		try{this.cnn.close();}catch(Exception ex){}
	}
	
	public static void emailNotificacaoAcessoDados(String msg){	

		SendMail mail = new SendMail();
		String texto = 
				"<body>"+
				"    <div style=\"font-size:11px;font-family: 'Lucida Sans Unicode', 'Lucida Grande', sans-serif; color:#666\">"+
/*				"        <a href=\"http://ntk2all.com.br\" target=\"_blank\"><img src=\"http://globalwebmasters.com/gate2all/logo.png\" border=\"0\" width=\"150\"></a>"+
*/				"        <div style=\"font-size:16px;color:#36c; border-top:1px solid #ddd; padding:10px 0\">ERRO NO WEBSERVICE</div>"+
				"        Senhores <br><br>"+
				"		<b>Importante:</b><br>"+
				"       "+(msg != null ? msg : "  OCORREU NO ACESSO A DADOS NO WEBSERVICE DO VACCINE NFE, FAVOR VERIFICAR SE O SERVIÇO DO MYSQL ESTA UP, O MAIS RÁPIDO POSSÍVEL")+"<BR><BR>"+
				"     <div style=\"border-top:1px solid #ddd; padding:5px 0; margin-top:10px; font-size:11px; color:#999\"><a style=\"text-decoration:none; color:#999\" href=\"http://ntk2all.com.br\">© 2013 Vaccine NFe</a></div>"+
				"        "+
				"     </div>"+
				"</body>";
		try {
			mail.sendHtmlMail("ALERTA WSDL VACCINE NFe (ACESSO A DADOS) ", texto, "ricardol.almeida@ntk.com.com",true);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}