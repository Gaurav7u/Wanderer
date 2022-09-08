package com.wanderer.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
public class PackageModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "package_id")
	private int packageId;
	
	@NotBlank(message = "Heading is mandatory")
	@NotNull(message = "Heading is mandatory")
	private String heading;
	
	@NotBlank(message = "Destination is mandatory")
	@NotNull(message = "Destination is mandatory")
	private String destination;
	
	@PositiveOrZero(message = "No of days can't be negative")
	@NotNull(message = "No of days is mandatory")
	private int days;
	
	@PositiveOrZero(message = "No of nights can't be negative")
	@NotNull(message = "No of nights is mandatory")
	private int nights;
	
	@PositiveOrZero(message = "Seats be negative")
	@NotNull(message = "Seats is mandatory")
	private int seats;
	
	@PositiveOrZero(message = "Price can't be negative")
	@NotNull(message = "Price is mandatory")
	private Double price;
	
	@NotBlank(message = "Product image is mandatory")
	@NotNull(message = "Productimage is mandatory")
	private String imageUrl;
	
	@NotNull(message = "Journey Date is mandatory")
	private LocalDate journeyDate;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "packages")
	@JsonIgnore
	private List<ScheduleModel> schedules;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy ="packages")
	@JsonIgnore
	private List<AmenetiesModel> ameneties;
	
	@OneToMany(mappedBy = "packages", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<BookingModel> bookings;
	
	@JsonIgnore
	@NotNull(message = "User must be present")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserModel user;

	public PackageModel() {
		super();
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public List<ScheduleModel> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<ScheduleModel> schedules) {
		this.schedules = schedules;
	}

	public List<AmenetiesModel> getAmeneties() {
		return ameneties;
	}

	public void setAmeneties(List<AmenetiesModel> ameneties) {
		this.ameneties = ameneties;
	}

	public List<BookingModel> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingModel> bookings) {
		this.bookings = bookings;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
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
				+ imageUrl + ", journeyDate=" + journeyDate + "]";
	}

}
