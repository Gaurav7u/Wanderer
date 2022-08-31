package com.wanderer.dto;

public class ValidationResponse {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ValidationResponse [message=" + message + "]";
	}
	
}
