package com.eltaieb.microservice.emailengine.service.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.eltaieb.microservice.emailengine.model.Message;
import com.eltaieb.microservice.emailengine.service.api.EmailService;

import lombok.extern.java.Log;

@Log
@Service
public class EmailServiceBean implements EmailService {

	 
	private JavaMailSender emailSender;
	
	public EmailServiceBean(JavaMailSender emailSender)
	{
		 this.emailSender=emailSender;
	}

	@Override
	public void sendSimpleMessage(Message msg) {
	        SimpleMailMessage message = toSimpleMailMessage(msg);
	        emailSender.send(message);
	}

	private SimpleMailMessage toSimpleMailMessage(Message msg) {
		SimpleMailMessage message =	new SimpleMailMessage(); 
        message.setTo(msg.getTo()); 
        message.setSubject(msg.getSubject()); 
        message.setText(msg.getBody());		
        return message;
	}
}
