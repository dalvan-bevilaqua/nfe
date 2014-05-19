package br.com.service.bean;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


/**  @author Ricardo Almeida
 *   @version 1.0
  */
public class Logger {

	private static Format formatDate;
	private static Format formatDateFileName;
	/*** Veja a lista de parametros antes de utilizar o este metodo.
	 * @see #log(String paramLevel, String paramMessage,Connection conn,int numProtocolo) 
	 */
	
	/***
	 *  Este metodo é utilizado para quando existir um erro na aplicação ele print no log e grava no banco
	 *  @throws IllegalStateException se nenhum  retorno for encontrado
	 *  @exception caso não consiga gravar a Exception SQLExceptio é tratada com try/catch
	 *  @return falso caso exista um erro na aplicação e verdadeiro caso não tenha erro.
	 *  @param o parametro paramLevel ,este parametro é usada para informar qual o tipo ,se erro ,log ou aviso
	 *  @param o parametro paramMessage ,este parametro recebe o tipo de mensagem a a ser gravada 
	 *  @param o parametro conn ,este parametro é usado para receber uma conexão com o banco para então gravar o log
	 *  @param o parametro numProtocolo ,este parametro é usado para passar o numero do protocolo , passa zero [0] caso não necessite do protocolo, exemplo iniciando aplicação.
	 */


	
	public synchronized static boolean log(String paramLevel, String paramMessage){
		boolean retorno=true;
		
		formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		String stringMessage = formatDate.format(new Date()) + " ["+ paramLevel +"] " + paramMessage;
		
		writerLog(stringMessage);
		return retorno;
		
	}
	
	private static void writerLog(String paramMessage){
		BufferedWriter out =null;
		try{	
			
			formatDateFileName = new SimpleDateFormat("yyyyMMddHH");
			//String path = System.getProperty("catalina.home"); 
			//props.load(new FileInputStream(path+"/conf/vaccineWSDL.properties"));
		    out = new BufferedWriter(new FileWriter("/usr/java/nfe/log/nfe_"+formatDateFileName.format(new Date())+".log", true));
		    //out = new BufferedWriter(new FileWriter("C:\\vaccinewsdl\\lognfe_"+formatDateFileName.format(new Date())+".log", true));
			out.write(paramMessage + "\n");
			out.close();
			
			// Imprime no console
			System.out.print(paramMessage + "\n");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
