package br.com.service.common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class Logger {
	
	public static String CONST_LEVEL_LOGGING 	= " LOG ";
	public static String CONST_LEVEL_WARNNING 	= " WRN ";
	public static String CONST_LEVEL_ERROR 		= " ERR ";
	
	private static Format formatDate;
	private static Format formatDateFileName;

	public static void log(String paramLevel, String paramMessage){
		formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		String stringMessage = formatDate.format(new Date()) + " ["+ paramLevel +"] " + paramMessage;
		try {
			writerLog(stringMessage);
		} catch (Exception e) {
			System.out.println(stringMessage);
		}
	}
	
	private static void writerLog(String paramMessage){
		try{
			Properties prop = Comuns.setupProperties();
			String stringPathFileLog = prop.getProperty("app.path.file.log");
			formatDateFileName = new SimpleDateFormat("yyyyMMdd");
//			System.out.println(stringPathFileLog + "wsdl_"+formatDateFileName.format(new Date())+".log");
			BufferedWriter out = new BufferedWriter(new FileWriter(stringPathFileLog + "wsdl_"+formatDateFileName.format(new Date())+".log", true));
			out.write(paramMessage + "\n");
			out.close();
			System.out.print(paramMessage + "\n");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String now() {
		final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	    return sdf.format(cal.getTime());

	  }	
	
}
