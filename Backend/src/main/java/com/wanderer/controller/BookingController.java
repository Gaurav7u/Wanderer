package com.wanderer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wanderer.dto.BookingModelDto;
import com.wanderer.model.BookingModel;
import com.wanderer.service.BookingService;

@RestController
@RequestMapping("/booking/")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private BookingModel booking;
	
	@PostMapping("addBooking")
	public ResponseEntity<String> addBooking(@Valid @RequestBody BookingModelDto bookingDto){
		booking.setBookingDate(bookingDto.getBookingDate());
		bookingService.create(booking);
		return new ResponseEntity<>("Booking Successfull, Booking ID is : " + booking.getBookingId(), HttpStatus.OK);
	}
	
	@GetMapping("bookinglist")
	public ResponseEntity<List<BookingModel>> getAllBookings(){
		return new ResponseEntity<>(bookingService.findAllBookings(), HttpStatus.OK);
	}
	
	@GetMapping("bookingWithId/{bookingId}")
	public ResponseEntity<BookingModel> getBookingById(@PathVariable String bookingId) {
		BookingModel currentBooking = bookingService.findBookingById(bookingId);
		if(currentBooking != null) {
			return new ResponseEntity<>(currentBooking, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("cancelBookingWithId/{bookingId}")
	public ResponseEntity<BookingModel> cancelBookingById(@PathVariable String bookingId){
		BookingModel cancelBooking = bookingService.findBookingById(bookingId);
		if(cancelBooking != null) {
			cancelBooking.setBookingStatus("Cancelled");
			bookingService.create(cancelBooking);
			return new ResponseEntity<>(cancelBooking, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
