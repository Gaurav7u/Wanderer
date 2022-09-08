package com.wanderer.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
public class BookingModel implements Serializable {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "booking_id")
	private String bookingId;

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
	
	@JsonIgnore
	@NotNull(message = "User must be present")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserModel user;
	
	@JsonIgnore
	@NotNull(message = "Package must be present")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "package_id")
	private PackageModel packages;
	
	private Double totalCost;
	
	
	public int getNoOfTourist() {
		return noOfTourist;
	}

	public void setNoOfTourist(int noOfTourist) {
		this.noOfTourist = noOfTourist;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public PackageModel getPackages() {
		return packages;
	}

	public void setPackages(PackageModel packages) {
		this.packages = packages;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
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

	public BookingModel() {
	}

	public BookingModel(String bookingId, LocalDate bookingDate, String bookingStatus, String paymentStatus,Double totalCost,int noOfTourist) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookingStatus = bookingStatus;
		this.paymentStatus = paymentStatus;
		this.totalCost=totalCost;
		this.noOfTourist=noOfTourist;
	}

	@Override
	public String toString() {
		return "BookingModel [bookingId=" + bookingId + ", bootkingDate=" + bookingDate + ", bookingStatus="
				+ bookingStatus + ", paymentStatus=" + paymentStatus + "]";
	}

}
