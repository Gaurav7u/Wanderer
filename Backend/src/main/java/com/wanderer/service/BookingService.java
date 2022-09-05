package com.wanderer.service;

import java.util.List;

import com.wanderer.model.BookingModel;

public interface BookingService {

	void create(BookingModel booking);

	List<BookingModel> findAllBookings();

	BookingModel findBookingById(String bookingId);

}
