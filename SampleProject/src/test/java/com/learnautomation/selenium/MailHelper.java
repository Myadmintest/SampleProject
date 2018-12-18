package com.learnautomation.selenium;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class MailHelper {

public static void main(String[] args) throws Exception {
	Email email = new SimpleEmail();
	email.setHostName("smtp.googleemail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("bdurgum@gmail.com","chander123"));
	email.setSSLOnConnect(true);
	email.getFromAddress();
	//email.getHeader("Test");
	email.getSubject();
	
	System.out.println(email.getToAddresses().size());
	
}
}