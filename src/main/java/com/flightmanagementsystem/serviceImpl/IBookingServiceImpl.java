package com.flightmanagementsystem.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmanagementsystem.entity.Booking;
import com.flightmanagementsystem.exceptions.BookingAlreadyExistsException;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;
import com.flightmanagementsystem.repository.IBookingRepository;
import com.flightmanagementsystem.service.IBookingService;

@Service
public class IBookingServiceImpl implements IBookingService{
	
	@Autowired
	private IBookingRepository bookingRepository;

	@Override
	public Booking addBooking(Booking booking) throws BookingAlreadyExistsException {
		
		Optional<Booking> b = bookingRepository.findById(booking.getBookingId());
		if (b.isPresent()) {
			throw new BookingAlreadyExistsException("Booking already exists with client name " + booking.getBookingId());
		} else {
			return bookingRepository.save(booking);
		}	
	}

	@Override
	public Booking viewBooking(long bookingId) throws ResourceNotFoundException {
	
		return bookingRepository.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("Booking Not Found in the database"));
	}

	@Override
	public Booking modifyBooking(Booking booking) throws ResourceNotFoundException {
		Booking bb = bookingRepository.findById(booking.getBookingId())
				.orElseThrow(() -> new ResourceNotFoundException("Booking Details are not found"));

		bb.setBookingId(booking.getBookingId());
		bb.setBookingDate(booking.getBookingDate());
		bb.setTicketCost(booking.getTicketCost());
		bb.setClient(booking.getClient());
		bb.setFlight(booking.getFlight());
		bb.setPassengerlist(booking.getPassengerlist());
		
		return bookingRepository.save(bb);
		
	}

	@Override
	public Booking deleteBooking(long bookingId) throws ResourceNotFoundException {
		
		Booking b1 = bookingRepository.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("booking Not Found in the database"));
		bookingRepository.delete(b1);
		return b1;
	}

	@Override
	public List<Booking> viewBookings() throws ResourceNotFoundException {
		
		List<Booking> list = bookingRepository.findAll();
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("Bookings are not there in the database");
		} else {
			return list;
		}
	}

}


