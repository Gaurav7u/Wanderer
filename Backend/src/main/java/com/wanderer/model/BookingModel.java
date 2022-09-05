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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Component
@Entity
public class BookingModel implements Serializable {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "booking_id")
	private String bookingId;

	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@NotBlank(message = "Booking date cannot be blank")
	@NotNull(message = "Booking date cannot be null")
	private String bookingDate;

	@NotBlank(message = "Booking status cannot be blank")
	@NotNull(message = "Booking status cannot be null")
	private String bookingStatus = "Booked";

	@NotBlank(message = "Payment status cannot be blank")
	@NotNull(message = "Payment status cannot be null")
	private String paymentStatus = "Paid";

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
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

	public BookingModel() {
	}

	public BookingModel(String bookingId, String bookingDate, String bookingStatus, String paymentStatus) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookingStatus = bookingStatus;
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "BookingModel [bookingId=" + bookingId + ", bootkingDate=" + bookingDate + ", bookingStatus="
				+ bookingStatus + ", paymentStatus=" + paymentStatus + "]";
	}

}
