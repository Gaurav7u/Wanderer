package com.wanderer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
public class AmenetiesModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ameneties_id")
	private int amenetiesId;

	@NotNull(message = "Description cannot be null")
	@NotBlank(message = "Description cannot be empty")
	private String description;
	
	@JsonIgnore
	@NotNull(message = "Package must be present")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "package_id")
	private PackageModel packages;

	
	public PackageModel getPackages() {
		return packages;
	}

	public void setPackages(PackageModel packages) {
		this.packages = packages;
	}

	public int getAmenetiesId() {
		return amenetiesId;
	}

	public void setAmenetiesId(int amenetiesId) {
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

	

	public AmenetiesModel(int amenetiesId,String description,PackageModel packages) {
		super();
		this.amenetiesId = amenetiesId;
		this.description = description;
		this.packages = packages;
	}

	@Override
	public String toString() {
		return "AmenetiesModel [amenetiesId=" + amenetiesId + ", description=" + description + ", packages=" + packages
				+ "]";
	}

	

}
