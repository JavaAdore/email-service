package com.eltaieb.microservice.emailengine.facade;

import com.eltaieb.microservice.emailengine.model.Message;

public interface EmailEngineFacade {

	void sendEmail(Message message);
 
 
	 
}
