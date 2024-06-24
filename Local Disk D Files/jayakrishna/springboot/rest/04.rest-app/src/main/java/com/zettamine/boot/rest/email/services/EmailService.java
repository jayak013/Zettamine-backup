package com.zettamine.boot.rest.email.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.zettamine.boot.rest.email.models.Email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;



@Service
public class EmailService {
	
	private JavaMailSender mailSender;
	
	public EmailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public boolean sendEmail(Email email) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		
		try {
			helper.setTo(email.getToMail());
			helper.setText(email.getBody(),true);
			helper.setSubject(email.getSubject());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
//		message.setTo(email.getToMail());
//		message.setText(email.getBody());
//		message.setSubject(email.getSubject());
		
		try {
			mailSender.send(mimeMessage);
			return true;
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return false;
	}
	
}
