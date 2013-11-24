package org.ftec.les.test;

import com.timgroup.jgravatar.Gravatar;

public class Teste {

//	public static void main(String[] args) {
//		Email em = new Email();
//		List<String> emails = new ArrayList<String>();
//		try {
//			emails.add("luan-g8@hotmail.com");
//			emails.add("luanrafaelcastor@gmail.com");
//			emails.add("lucasg_campos@hotmail.com");
//			emails.add("rogerio.reisss@gmail.com");
//			emails.add("spfcwilliam@hotmail.com");
//			em.enviarEmail(emails);
//		} catch (EmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {
		Gravatar gr = new Gravatar();
		byte[] aa = gr.download("teste@mail.com");
		System.out.println(aa);
	}
	
	
}
