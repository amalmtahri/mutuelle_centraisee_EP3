package com.mutuelle.application.demo;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MaileSend {


	  public static void send(String from,String pwd,String to,String sub,String msg){
		    //Propri�t�s
		    Properties p = new Properties();
		    p.put("mail.smtp.host", "smtp.gmail.com");
		    p.put("mail.smtp.socketFactory.port", "465");
		    p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		    p.put("mail.smtp.auth", "true");
		    p.put("mail.smtp.port", "465");
		    //Session
		    Session s = Session.getDefaultInstance(p,
		      new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication(from, pwd);
		      }
		    });
		    //composer le message
		    try {
		      MimeMessage m = new MimeMessage(s);
		      m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		      m.setSubject(sub);
		      m.setText(msg);
		      //envoyer le message
		      Transport.send(m);
		      System.out.println("Message envoy� avec succ�s");
		    } catch (MessagingException e) {
		      e.printStackTrace();
		    }
		  }
}

