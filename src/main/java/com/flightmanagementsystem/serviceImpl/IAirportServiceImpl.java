package com.flightmanagementsystem.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmanagementsystem.entity.Airport;
import com.flightmanagementsystem.exceptions.AirportAlreadyExistsException;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;
import com.flightmanagementsystem.repository.IAirportRepository;
import com.flightmanagementsystem.service.IAirportService;
@Service
public class IAirportServiceImpl implements IAirportService{
	
	@Autowired
	private IAirportRepository airportRepository;

	@Override
	public Airport viewAirport(Airport airport) throws ResourceNotFoundException {
		return airportRepository.findById(airport.getAirportId())
				.orElseThrow(() -> new ResourceNotFoundException("Airport Not Found in the database"));
		
	}

	@Override
	public List<Airport> viewAllAirports() throws ResourceNotFoundException {
	
		List<Airport> list = airportRepository.findAll();
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("No airports are there in the database");
		} else {
			return list;
		}
	}

	@Override
	public Airport addAirport(Airport airport) throws AirportAlreadyExistsException {

		Optional<?> aa = airportRepository.findById(airport.getAirportId());
		Airport a1 = null;
		if (aa.isPresent()) {
			throw new AirportAlreadyExistsException("Airport already exists with Id " + airport.getAirportId());
		} else {
			a1 = airportRepository.save(airport);
		}

		return a1;
	}

	@Override
	public Airport deleteAirport(long airportId) throws ResourceNotFoundException {
		
		Airport b1 = airportRepository.findById(airportId)
				.orElseThrow(() -> new ResourceNotFoundException("Airport Not Found in the database"));
		airportRepository.delete(b1);
		return b1;
	
	}

}
