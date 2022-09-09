package com.wanderer.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class PackageModelNoImage implements Serializable{
	
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
	@NotNull(message = "Journey Date is mandatory") 
	private String journeyDate;
	
	public PackageModelNoImage() {
		super();
	}
	public PackageModelNoImage(String heading,String destination,int days,int nights,int seats,Double price,String journeyDate) {
		super();
		this.heading = heading;
		this.destination = destination;
		this.days = days;
		this.nights = nights;
		this.seats = seats;
		this.price = price;
		this.journeyDate=journeyDate;
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
	
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
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
	@Override
	public String toString() {
		return "PackageModelNoImage [heading=" + heading + ", destination=" + destination + ", days=" + days
				+ ", nights=" + nights + ", seats=" + seats + ", price=" + price + ", journeyDate=" + journeyDate + "]";
	}
	
	
	
	

}
