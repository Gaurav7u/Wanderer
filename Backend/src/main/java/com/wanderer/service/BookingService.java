package com.wanderer.service;

import java.util.List;

import com.wanderer.model.BookingModel;
import com.wanderer.model.UserModel;

public interface BookingService {

	BookingModel save(BookingModel booking,UserModel user,int packageId);

	List<BookingModel> findAllBookingsByUser(UserModel user);
	List<BookingModel> findAllBookingsByAdmin(int id);
	BookingModel findBookingById(String bookingId);
	String cancelBooking(String bookingId);

}
