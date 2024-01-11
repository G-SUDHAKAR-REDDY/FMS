package com.flightmanagementsystem.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmanagementsystem.entity.Flight;
import com.flightmanagementsystem.exceptions.FlightAlreadyExistsException;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;
import com.flightmanagementsystem.repository.IFlightRepository;
import com.flightmanagementsystem.service.IFlightService;
@Service
public class IFlightServiceImpl implements IFlightService{
	
	
	@Autowired
	private IFlightRepository flightRepository;

	@Override
	public Flight addFlight(Flight flight) throws FlightAlreadyExistsException {
		
		Optional<?> f = flightRepository.findById(flight.getFlightNumber());
		Flight fl = null;
		if (f.isPresent()) {
			throw new FlightAlreadyExistsException("Flight already exists with flight name " + flight.getFlightNumber());
		} else {
			fl = flightRepository.save(flight);
		}

		return fl;
	}
	

	@Override
	public Flight viewFlight(long flightNumber) throws ResourceNotFoundException {
		return flightRepository.findById(flightNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Flight Not Found in the database"));
	}
	@Override
	public Flight modifyFlight(Flight flight) throws ResourceNotFoundException {
	
		Flight ff = flightRepository.findById(flight.getFlightNumber())
				.orElseThrow(() -> new ResourceNotFoundException("Flight Details are not found"));

		ff.setFlightModel(flight.getFlightModel());
		ff.setFlightNumber(flight.getFlightNumber());
		ff.setCarrierName(flight.getCarrierName());
		ff.setSeatCapacity(flight.getSeatCapacity());
		
		return flightRepository.save(ff);
	}

	@Override
	public Flight deleteFlight(long flightNumber) throws ResourceNotFoundException {
		
		Flight f1 = flightRepository.findById(flightNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Flight Not Found in the database"));
		flightRepository.delete(f1);
		return f1;
	}

	@Override
	public List<Flight> viewFlights() throws ResourceNotFoundException {

		List<Flight> list = flightRepository.findAll();
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("Flights are not there in the database");
		} else {
			return list;
		}
	}

}
