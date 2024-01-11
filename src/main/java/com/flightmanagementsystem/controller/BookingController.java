package com.flightmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagementsystem.entity.Booking;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;
import com.flightmanagementsystem.service.IBookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
	
	
	@Autowired
	private IBookingService bookingService;
	
	@PostMapping("/add-booking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) throws Exception {
		if (booking == null) {
			throw new Exception("Object is null");
		} 
			return new ResponseEntity<Booking>(bookingService.addBooking(booking), HttpStatus.CREATED);
		}

	
	@PutMapping("/modify-booking")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) throws Exception {
		if (booking!= null) {
			return new ResponseEntity<Booking>(bookingService.modifyBooking(booking), HttpStatus.OK);
		}
		throw new Exception("Booking Object is null or empty");
	}

	@DeleteMapping("/delete-booking/{bookingId}")
	public ResponseEntity<Booking> deleteBooking(@PathVariable long bookingId) throws Exception {
		if (bookingId == 0) {
			throw new Exception("Booking Id is Invalid");
		}
		return new ResponseEntity<Booking>(bookingService.deleteBooking(bookingId), HttpStatus.OK);
	}

	@GetMapping("/veiw-all-bookings")
	public ResponseEntity<List<Booking>> viewBookings() throws ResourceNotFoundException {
		return new ResponseEntity<List<Booking>>(bookingService.viewBookings(), HttpStatus.OK);
	}

	@GetMapping("/view-booking-by-id/{bookingId}")
	public ResponseEntity<Booking> viewBooking(@PathVariable long bookingId) throws Exception {
		if (bookingId == 0) {
			throw new Exception("Booking Id is Invalid");
		}
		return new ResponseEntity<Booking>(bookingService.viewBooking(bookingId), HttpStatus.OK);
	}

}
