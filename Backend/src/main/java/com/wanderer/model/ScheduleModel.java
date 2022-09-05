package com.wanderer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
public class ScheduleModel implements Serializable {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "schedule_id")
	private String scheduleId;

	@PositiveOrZero(message = "Day Number can't be negative")
	@NotNull(message = "Day Number is mandatory")
	private int dayNo;

	@NotBlank(message = "Description is mandatory")
	@NotNull(message = "Description is mandatory")
	private String description;

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		scheduleId = scheduleId;
	}

	public int getDayNo() {
		return dayNo;
	}

	public void setDayNo(int dayNo) {
		this.dayNo = dayNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ScheduleModel() {
	}

	public ScheduleModel(String scheduleId, int dayNo, String description) {
		super();
		scheduleId = scheduleId;
		this.dayNo = dayNo;
		this.description = description;
	}

	@Override
	public String toString() {
		return "ScheduleModel [ScheduleId=" + scheduleId + ", dayNo=" + dayNo + ", description=" + description + "]";
	}

}
