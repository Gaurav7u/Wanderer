package com.wanderer.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class AmenetiesDto {
	
	@NotNull(message = "Description cannot be null")
	@NotBlank(message = "Description cannot be empty")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
