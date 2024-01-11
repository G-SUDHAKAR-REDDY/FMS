package com.flightmanagementsystem.service;

import java.util.List;

import com.flightmanagementsystem.entity.Flight;
import com.flightmanagementsystem.exceptions.FlightAlreadyExistsException;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;

public interface IFlightService {

	public Flight addFlight(Flight flight) throws FlightAlreadyExistsException;
	public Flight viewFlight(long flightNumber) throws ResourceNotFoundException;
	public Flight modifyFlight(Flight flight) throws ResourceNotFoundException;
	public Flight deleteFlight(long flightNumber) throws ResourceNotFoundException;
	public List<Flight> viewFlights() throws ResourceNotFoundException;

}
