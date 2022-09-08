package com.wanderer.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class ScheduleDto {

	@NotBlank(message = "Day/Night is mandatory")
	@NotNull(message = "Day/Night is mandatory")
	private String dayOrNightNo;

	@NotBlank(message = "Description is mandatory")
	@NotNull(message = "Description is mandatory")
	private String description;

	public String getDayOrNightNo() {
		return dayOrNightNo;
	}

	public void setDayOrNightNo(String dayOrNightNo) {
		this.dayOrNightNo = dayOrNightNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
