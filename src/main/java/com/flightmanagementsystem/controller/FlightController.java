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

import com.flightmanagementsystem.entity.Flight;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;
import com.flightmanagementsystem.service.IFlightService;

@RestController
@RequestMapping("/api/booking")
public class FlightController {
	
	@Autowired
	private IFlightService flightService;
	

	@PostMapping("/add-flight")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) throws Exception {
		if (flight == null) {
			throw new Exception("Object is null");
		} else {
			return new ResponseEntity<Flight>(flightService.addFlight(flight), HttpStatus.CREATED);
		}

	}
	@PutMapping("/modify-Flight")
	public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight) throws Exception {
		if (flight!= null) {
			return new ResponseEntity<Flight>(flightService.modifyFlight(flight), HttpStatus.OK);
		}
		throw new Exception("Flight Object is null or empty");
	}

	@DeleteMapping("/delete-flight/{flightNumber}")
	public ResponseEntity<Flight> deleteFlight(@PathVariable long flightNumber) throws Exception {
		if (flightNumber == 0) {
			throw new Exception("Flight Id is Invalid");
		}
		return new ResponseEntity<Flight>(flightService.deleteFlight(flightNumber), HttpStatus.OK);
	}

	@GetMapping("/veiw-all-flights")
	public ResponseEntity<List<Flight>> viewflights() throws ResourceNotFoundException {
		return new ResponseEntity<List<Flight>>(flightService.viewFlights(), HttpStatus.OK);
	}

	@GetMapping("/view-flight-by-id/{flightNumber}")
	public ResponseEntity<Flight> viewFlight(@PathVariable long flightNumber) throws Exception {
		if (flightNumber == 0) {
			throw new Exception("Flight Id is Invalid");
		}
		return new ResponseEntity<Flight>(flightService.viewFlight(flightNumber), HttpStatus.OK);
	}

}
