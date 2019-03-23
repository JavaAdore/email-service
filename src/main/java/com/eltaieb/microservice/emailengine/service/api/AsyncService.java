package com.eltaieb.microservice.emailengine.service.api;

import org.springframework.stereotype.Service;

import com.eltaieb.microservice.emailengine.model.Message;


public interface AsyncService   {

	
	void pushEmailToNotificationMessageHistoryQueue(Message message);
 

}
