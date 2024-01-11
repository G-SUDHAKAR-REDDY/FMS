package com.flightmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagementsystem.entity.Airport;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;
import com.flightmanagementsystem.service.IAirportService;

@RestController
@RequestMapping("/api/airport")
public class AirportController {
	
	@Autowired
	private IAirportService airportService;
	
	@PostMapping("/add-airport")
	public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) throws Exception {
		if (airport == null) {
			throw new Exception("Object is null");
		} else {
			return new ResponseEntity<Airport>(airportService.addAirport(airport), HttpStatus.CREATED);
		}
	}
		@DeleteMapping("/delete-airport/{airportId}")
		public ResponseEntity<Airport> deleteAirport(@PathVariable long airportId) throws Exception {
			if (airportId == 0) {
				throw new Exception("Airport Id is Invalid");
			}
			return new ResponseEntity<Airport>(airportService.deleteAirport(airportId),HttpStatus.OK);
		}
	
	@GetMapping("/view-airport-by-id/{airportId}")
	public ResponseEntity<Airport> viewAirport(@PathVariable long airportId) throws Exception {
		if (airportId == 0) {
			throw new Exception("Airport Id is Invalid");
		}
		return new ResponseEntity<Airport>(airportService.viewAirport(null), HttpStatus.OK);
			
	}
	@GetMapping("/veiw-all-airports")
	public ResponseEntity<List<Airport>> viewAirports() throws ResourceNotFoundException {
		return new ResponseEntity<List<Airport>>(airportService.viewAllAirports(), HttpStatus.OK);
	}
}
