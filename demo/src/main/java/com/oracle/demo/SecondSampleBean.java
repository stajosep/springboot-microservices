package com.oracle.demo;

public class SecondSampleBean {

	private String message;

	@Override
	public String toString() {
		return "SecondSampleBean [message=" + message + "]";
	}

	public SecondSampleBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
