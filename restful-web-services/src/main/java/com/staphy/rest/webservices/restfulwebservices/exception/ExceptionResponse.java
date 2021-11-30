package com.staphy.rest.webservices.restfulwebservices.exception;

import java.util.Date;

//
public class ExceptionResponse {
	
	private Date dateTime;
	private String message;
	private String details;
	
	public ExceptionResponse(Date dateTime, String message, String details) {
		super();
		this.dateTime = dateTime;
		this.message = message;
		this.details = details;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	

}
