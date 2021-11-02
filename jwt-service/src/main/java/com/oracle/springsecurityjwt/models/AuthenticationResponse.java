package com.oracle.springsecurityjwt.models;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable{

	public AuthenticationResponse(String jwt) {
		// TODO Auto-generated constructor stub
		this.jwt = jwt;
	}

	private final String jwt;
	
	public String getJwt() {
		return jwt;
	}
	
}
