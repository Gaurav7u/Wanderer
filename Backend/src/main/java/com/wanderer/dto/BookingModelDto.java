package com.wanderer.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.stereotype.Component;

@Component
public class BookingModelDto {

	@NotNull(message = "Booking date cannot be null")
	private LocalDate bookingDate;
	
	@Positive(message = "No of tourist must be positive")
	@NotNull(message = "No of tourist is required")
	private int noOfTourist;

	@NotBlank(message = "Booking status cannot be blank")
	@NotNull(message = "Booking status cannot be null")
	private String bookingStatus = "Booked";

	@NotBlank(message = "Payment status cannot be blank")
	@NotNull(message = "Payment status cannot be null")
	private String paymentStatus = "Paid";
	
	private Double totalCost;

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public int getNoOfTourist() {
		return noOfTourist;
	}

	public void setNoOfTourist(int noOfTourist) {
		this.noOfTourist = noOfTourist;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public BookingModelDto() {
	}

	public BookingModelDto(LocalDate bookingDate, String bookingStatus, String paymentStatus,Double totalCost,int noOfTourist) {
		super();
		this.bookingDate = bookingDate;
		this.bookingStatus = bookingStatus;
		this.paymentStatus = paymentStatus;
		this.totalCost=totalCost;
		this.noOfTourist=noOfTourist;
	}

	@Override
	public String toString() {
		return "BookingModel [bookingDate=" + bookingDate + ", bookingStatus=" + bookingStatus + ", paymentStatus="
				+ paymentStatus + "]";
	}

}
