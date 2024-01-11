package com.flightmanagementsystem.service;

import java.util.List;

import com.flightmanagementsystem.entity.Airport;
import com.flightmanagementsystem.exceptions.AirportAlreadyExistsException;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;

public interface IAirportService {
	
	public Airport addAirport(Airport airport) throws AirportAlreadyExistsException;
	public Airport deleteAirport(long airportId) throws ResourceNotFoundException;
	public Airport viewAirport(Airport airport) throws ResourceNotFoundException;
	public List<Airport> viewAllAirports() throws ResourceNotFoundException;

}
