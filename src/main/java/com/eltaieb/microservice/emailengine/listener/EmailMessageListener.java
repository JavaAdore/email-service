package com.eltaieb.microservice.emailengine.listener;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.eltaieb.microservice.emailengine.facade.EmailEngineFacade;
import com.eltaieb.microservice.emailengine.model.Message;
import com.eltaieb.microservice.emailengine.service.api.AsyncService;
import com.google.gson.Gson;

@Service
public class EmailMessageListener {

	private EmailEngineFacade emailEngineFacade;
	private AsyncService asyncService;
	private RabbitTemplate rabbitTemplate;
	public EmailMessageListener(EmailEngineFacade emailEngineFacade,AsyncService asyncService)
	{
		this.emailEngineFacade=emailEngineFacade;
		this.asyncService=asyncService;
	}
	
	/**
	 * Message listener  
	 * 
	 * @param  messageAsGson String represents Message
	 */
	@RabbitListener(queues = "emailQueue")
	public void receiveMessageForApp1(final String messageAsGson) {
		
		Message message = new Gson().fromJson(messageAsGson, Message.class);
		try
		{
			emailEngineFacade.sendEmail(message);
			message.setDelivertyTime(LocalDateTime.now());
		}finally
		{
			asyncService.pushEmailToNotificationMessageHistoryQueue(message);
		}
		
	}
}
