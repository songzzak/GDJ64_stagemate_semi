package com.stagemate.common;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class AuthMailSender {
	private static final String MAIL_ACCOUNT_PATH = "/security.properties";
	private static final String SENDER_NAME = "STAGEMATE";
	private static final String CHARSET = "UTF-8";
	
	private final String fullPath = AuthMailSender.class.getResource(MAIL_ACCOUNT_PATH).getPath();
	
	private final Properties mailAccount;
	private final Authenticator authMailGenerator;
	
	public AuthMailSender() {
		mailAccount = PropertiesGenerator.by(fullPath);
		authMailGenerator = new AuthMailGenerator(mailAccount.getProperty("senderEmail"), 
												mailAccount.getProperty("senderPw"));
	}
	
	public void send(String receiver, String authCode) {
        final Session session = Session.getDefaultInstance(generateProp(), authMailGenerator);
		final MimeMessage mimeMsg = new MimeMessage(session);
        
		try {
        	mimeMsg.setSentDate(new Date());
        	mimeMsg.setFrom(new InternetAddress(mailAccount.getProperty("senderEmail"), SENDER_NAME));
        	mimeMsg.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
        	mimeMsg.setSubject("제목", CHARSET);
        	mimeMsg.setText("인증 번호: " + authCode, CHARSET);
        	
        	Transport.send(mimeMsg);
        } catch(AddressException e) {            
            e.printStackTrace();          
        } catch(MessagingException e) {            
        	e.printStackTrace();
        } catch(UnsupportedEncodingException e) {
        	e.printStackTrace();
        }
	}
	
	private Properties generateProp() {
		Properties prop = System.getProperties();
		prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        return prop;
	}	
}
