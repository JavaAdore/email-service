package com.eltaieb.microservice.emailengine.facade;

import org.springframework.stereotype.Service;

import com.eltaieb.microservice.emailengine.model.Message;
import com.eltaieb.microservice.emailengine.service.api.EmailService;
  
@Service()
public class EmailEngineFacadeBean implements EmailEngineFacade {

	private EmailService emailService;
	
	public EmailEngineFacadeBean(EmailService emailService)
	{
		this.emailService=emailService;
	}
	
	@Override
	public void sendEmail(Message msg) {
		emailService.sendSimpleMessage(msg);		
	}

  	 
	 	 

}
