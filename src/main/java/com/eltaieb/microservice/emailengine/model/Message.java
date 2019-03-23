package com.eltaieb.microservice.emailengine.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String referenceType;
	private String referenceNumber;
	private String to;
	private String subject;
	private String body;
	private LocalDateTime dateTime;
	private LocalDateTime delivertyTime = LocalDateTime.now();
	
}
