package com.wanderer.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanderer.model.BookingModel;
import com.wanderer.repository.BookingRepository;
import com.wanderer.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public void create(BookingModel booking) {
		bookingRepository.save(booking);
	}

	@Override
	public List<BookingModel> findAllBookings() {
		return bookingRepository.findAll();
	}

	@Override
	public BookingModel findBookingById(String bookingId) {
		return bookingRepository.findById(bookingId).get();
	}

}
