package br.com.service.common;


import org.apache.commons.mail.HtmlEmail;

	public class SendMail {
		
		 public SendMail(){}
		 	
		 	
		 	public void sendHtmlMail(String subject, String texto, String emailTo, boolean copia)throws Exception{
		    	try{
			        HtmlEmail email = new HtmlEmail();
			        email.setDebug(false);
			        email.setHostName(ConfigEmail.EMAIL_SMTP.getString());
			        email.setAuthentication(ConfigEmail.EMAIL_EMAIL.getString(), ConfigEmail.EMAIL_SENHA.getString());
			        email.setFrom(ConfigEmail.EMAIL_FROM.getString());
			        email.addTo(emailTo);
			        email.setSubject(subject);
			        email.setHtmlMsg(texto);
			        email.setSmtpPort(25);
			        email.setSSL(true);
			        email.send();
			        System.out.println("send ok");
		    	}catch (Exception e) {
					e.printStackTrace();
				}
		    }
		 	
		 	public void sendHtmlMail(String subject, String texto, String emailTo, Boolean ccDesenv) throws Exception{
		    	try{
			        HtmlEmail email = new HtmlEmail();
			        email.setDebug(false);
			        email.setHostName(ConfigEmail.EMAIL_SMTP.getString());
			        email.setAuthentication(ConfigEmail.EMAIL_EMAIL.getString(), ConfigEmail.EMAIL_SENHA.getString());
			        email.setFrom(ConfigEmail.EMAIL_FROM.getString());
			        email.addTo(emailTo);
			        email.setSubject(subject);
			        email.setHtmlMsg(texto);
			        email.setSmtpPort(25);
			        email.setSSL(true);
			        email.send();
			        System.out.println("send ok");
		    	}catch (Exception e) {
					e.printStackTrace();
				}
		    }

		  
}