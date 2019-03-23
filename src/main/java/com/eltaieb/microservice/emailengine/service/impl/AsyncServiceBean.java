package com.eltaieb.microservice.emailengine.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.eltaieb.microservice.emailengine.config.ServiceConstant;
import com.eltaieb.microservice.emailengine.model.Message;
import com.eltaieb.microservice.emailengine.service.api.AsyncService;
import com.google.gson.Gson;

@Service
public class AsyncServiceBean implements AsyncService    {
 
	private RabbitTemplate rabbitTemplate;
	public AsyncServiceBean(RabbitTemplate rabbitTemplate)
	{
		this.rabbitTemplate=rabbitTemplate;
	}
	
	@Async
	@Override
	public void pushEmailToNotificationMessageHistoryQueue(Message message) {
		rabbitTemplate.convertAndSend(ServiceConstant.NOTIFICATION_HISTORY_MESSAGE_EXCHANGE_NAME,ServiceConstant.NOTIFICATION_HISTORY_MESSAGE_EMAIL_QUEUE_BINDING_KEY, new Gson().toJson(message));
	}
	
}
