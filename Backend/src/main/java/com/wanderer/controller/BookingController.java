package com.wanderer.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.bind.annotation.RestController;
import com.wanderer.dto.BookingModelDto;
import com.wanderer.model.BookingModel;
import com.wanderer.model.UserModel;
import com.wanderer.serviceImpl.BookingServiceImpl;
import com.wanderer.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/booking/")
public class BookingController {
	
	@Autowired
	private BookingServiceImpl bookingService;
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("{packageId}")
	public ResponseEntity<String> addBooking(@Valid @RequestBody BookingModelDto bookingDto,@PathVariable int packageId,Principal principal){
		BookingModel booking=new BookingModel();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		booking.setBookingDate(LocalDate.parse(bookingDto.getBookingDate(), formatter));
		booking.setNoOfTourist(bookingDto.getNoOfTourist());
		UserModel user=userService.findByEmail(principal.getName());
		bookingService.save(booking,user,packageId);
		return new ResponseEntity<>("Booking Successfull, Booking ID is : " + booking.getBookingId(), HttpStatus.OK);
	}
	
	@GetMapping("foruser")
	public ResponseEntity<List<BookingModel>> getAllBookings(Principal principal){
		UserModel user=userService.findByEmail(principal.getName());
		return new ResponseEntity<>(bookingService.findAllBookingsByUser(user), HttpStatus.OK);
	}
	@GetMapping("foradmin")
	public ResponseEntity<List<BookingModel>> getAllBookingsAdmin(Principal principal){
		int id=userService.findByEmail(principal.getName()).getUserId();
		return new ResponseEntity<>(bookingService.findAllBookingsByAdmin(id), HttpStatus.OK);
	}
	
	@PutMapping("{bookingId}")
	public ResponseEntity<String> cancelBooking(@PathVariable String bookingId){
		
			return new ResponseEntity<>(bookingService.cancelBooking(bookingId),HttpStatus.OK);
	}

}
