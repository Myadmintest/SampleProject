package com.learnautomation.selenium;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
 
public class GmailInbox {
 
    public static void main(String[] args) {
 
        GmailInbox gmail = new GmailInbox();
        gmail.read();
 
    }
 
    public void read() {
 
        Properties props = new Properties();
 
        try {
        	System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");

           // props.load(new FileInputStream(new File("C:\\smtp.properties")));
            Session session = Session.getDefaultInstance(props, null);
 
            Store store = session.getStore("imaps");
            store.connect("smtp.gmail.com", "bdurgum@gmail.com", "chander123");
 
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();
 
            System.out.println("Total Messages:- " + messageCount);
 
            Message[] messages = inbox.getMessages();
            System.out.println("------------------------------");
           
            for (int i = messages.length-1; i>=0 ; i--) {
            	Message message = messages[i];
            	if (message.getSubject().equals("Test message")) {
					
            		System.out.println(message.getSubject());
            		MimeMultipart minemultipart = (MimeMultipart)message.getContent();
            	System.out.println(getTextFromMimeMultipart(minemultipart));
            	break;
			}
            } 
            inbox.close(true);
            store.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart)  throws MessagingException, IOException{
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.getContent() instanceof MimeMultipart){
                result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
            }
        }
        return result;
    }

}
