package org.fatec.les.model.utils;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;



public class Email {

	
	HtmlEmail email = new HtmlEmail();
	
	public void enviarEmail(List<String> enderecos) throws EmailException{
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		
		for (String endereco : enderecos) {
			email.addCc(endereco);
		}
		
		email.setFrom("camisetasdazueira@gmail.com", "Camisaria Da Zueira"); // remetente
		email.setSubject("Mensagem de Teste"); // assunto do e-mail 
		email.setHtmlMsg(""
				+ "<html>"
					+ "<body>"
						+ "<a href='localhost:8080/ecommerce'>Confirmar</a>"
					+ "</body>"
				+ "</html>");
		email.setAuthentication("camisetasdazueira@gmail.com", "zueira100limites");
		email.setDebug(true);
		email.setSSL(true);
		email.send(); //envia o e-mail
	}
	
	
	
}
