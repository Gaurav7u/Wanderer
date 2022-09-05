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

@Entity
@Component
public class PackageModel implements Serializable{
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "package_id")
	private String packageId;
	@NotBlank(message = "Heading is mandatory")
	@NotNull(message="Heading is mandatory")
	private String heading;
	@NotBlank(message = "Destination is mandatory")
	@NotNull(message="Destination is mandatory")
	private String destination;
	@PositiveOrZero(message = "No of days can't be negative")
	@NotNull(message="No of days is mandatory")
	private int days;
	@PositiveOrZero(message = "No of nights can't be negative")
	@NotNull(message="No of nights is mandatory")
	private int nights;
	@PositiveOrZero(message = "Seats be negative")
	@NotNull(message="Seats is mandatory")
	private int seats;
	@PositiveOrZero(message = "Price can't be negative")
	@NotNull(message="Price is mandatory")
	private Double price;
	@NotBlank(message = "Product image is mandatory")
	@NotNull(message="Productimage is mandatory")
	private String imageUrl;
	public PackageModel() {
		super();
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getNights() {
		return nights;
	}
	public void setNights(int nights) {
		this.nights = nights;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getPhotosImagePath() {
		if (imageUrl == null)
			return null;

		return "/package-photos/" + packageId + "/" + imageUrl;
	}
	@Override
	public String toString() {
		return "PackageModel [packageId=" + packageId + ", heading=" + heading + ", destination=" + destination
				+ ", days=" + days + ", nights=" + nights + ", seats=" + seats + ", price=" + price + ", imageUrl="
				+ imageUrl + "]";
	}
	
	

}
