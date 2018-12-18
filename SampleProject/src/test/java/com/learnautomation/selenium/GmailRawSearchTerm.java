package com.learnautomation.selenium;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

public class GmailRawSearchTerm {

	private Message getEmail(String emailID, String password, String subjectToBeSearched) throws Exception {
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");

		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect("imap.gmail.com", emailID, password);

		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE);

		Message[] messages = null;
		boolean mailFound = false;
		Message email = null;

		for (int i = 0; i < 30; i++) {
		    messages = folder.search(new SubjectTerm("Access for less secure apps has been turned on"), folder.getMessages());
		    if (messages.length == 0) {
		        Thread.sleep(10000);
		    }
		}

		for (Message mail : messages) {
		    if (!mail.isSet(Flags.Flag.SEEN)) {
		        email = mail;
		        mailFound = true;
		    }
		}

		if (!mailFound) {
		    throw new Exception("Could not found Email");
		}

		return email;
		}

	}
