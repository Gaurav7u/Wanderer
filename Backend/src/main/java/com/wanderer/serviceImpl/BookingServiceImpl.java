package com.wanderer.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanderer.exception.NotFoundException;
import com.wanderer.exception.QuantityExceedException;
import com.wanderer.model.BookingModel;
import com.wanderer.model.PackageModel;
import com.wanderer.model.UserModel;
import com.wanderer.repository.BookingRepository;
import com.wanderer.repository.PackageRepository;
import com.wanderer.repository.UserRepository;
import com.wanderer.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private PackageRepository prepo;

	@Override
	public BookingModel save(BookingModel booking,UserModel user,int packageId) {
		PackageModel packages=prepo.findById(packageId).orElseThrow(()->new NotFoundException("Package not found with id : "+packageId));
		if(packages.getSeats()<booking.getNoOfTourist())
		{
			throw new QuantityExceedException("No of tourist is higher than the seats available.");
		}
		if(packages.getJourneyDate().isBefore(booking.getBookingDate()))
		{
			throw new QuantityExceedException("Booking is over.");
		}
		booking.setTotalCost(packages.getPrice()*booking.getNoOfTourist());
		booking.setBookingStatus("Booked");
		booking.setPaymentStatus("Paid");
		booking.setPackages(packages);
		booking.setUser(user);
		packages.setSeats(packages.getSeats()-booking.getNoOfTourist());
		prepo.save(packages);
		return bookingRepository.save(booking);
	}

	//for user
	@Override
	public List<BookingModel> findAllBookingsByUser(UserModel user) {
		return bookingRepository.findAllByUser(user);
	}

	@Override
	public BookingModel findBookingById(String bookingId) {
		return bookingRepository.findById(bookingId).orElseThrow(()->new NotFoundException("Booking not found with id : "+bookingId));
	}
    //for admin
	@Override
	public List<BookingModel> findAllBookingsByAdmin(int id) {
		UserModel user = urepo.findById(id).orElseThrow(()->new NotFoundException("User not found with id : "+id)); 
		List<PackageModel> packages = prepo.findAllByUser(user);
		List<BookingModel> bookings= new ArrayList<>();
		for(PackageModel p:packages)
		{
			bookings.addAll(bookingRepository.findAllByPackages(p));
		}
		return bookings;
	}

	@Override
	public String cancelBooking(String bookingId) {
		BookingModel booking=findBookingById(bookingId);
		PackageModel packages = prepo.findById(booking.getPackages().getPackageId()).orElseThrow(()->new NotFoundException("User not found with id : "+booking.getPackages().getPackageId()));
		packages.setSeats(packages.getSeats()+booking.getNoOfTourist());
		booking.setBookingStatus("Cancelled");
		booking.setPaymentStatus("Refunded");
		prepo.save(packages);
		bookingRepository.save(booking);
		return "Booking cancelled with id: "+bookingId;
	}

}
