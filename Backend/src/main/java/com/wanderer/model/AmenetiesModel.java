package com.wanderer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
public class AmenetiesModel implements Serializable {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ameneties_id")
	private String amenetiesId;

	@NotNull(message = "Description cannot be null")
	@NotBlank(message = "Description cannot be empty")
	private String description;

	public String getAmenetiesId() {
		return amenetiesId;
	}

	public void setAmenetiesId(String amenetiesId) {
		this.amenetiesId = amenetiesId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AmenetiesModel() {
	}

	public AmenetiesModel(String amenetiesId, String description) {
		super();
		this.amenetiesId = amenetiesId;
		this.description = description;
	}

	@Override
	public String toString() {
		return "AmenetiesModel [amenetiesId=" + amenetiesId + ", description=" + description + "]";
	}

}
