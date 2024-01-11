package com.flightmanagementsystem.service;

import java.util.List;

import com.flightmanagementsystem.entity.Booking;
import com.flightmanagementsystem.exceptions.BookingAlreadyExistsException;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;

public interface IBookingService {
	
	public Booking addBooking(Booking booking) throws BookingAlreadyExistsException;
	public Booking viewBooking(long bookingId) throws ResourceNotFoundException;
	public Booking modifyBooking(Booking booking) throws ResourceNotFoundException;
	public Booking deleteBooking(long bookingId) throws ResourceNotFoundException;
	public List<Booking> viewBookings() throws ResourceNotFoundException;
	

}
