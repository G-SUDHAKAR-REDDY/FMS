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

import com.flightmanagementsystem.entity.ScheduledFlight;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;
import com.flightmanagementsystem.service.IScheduledFlightService;
@RestController
@RequestMapping("/api/flightSchedule")
public class ScheduledFlightController {
	
	@Autowired
	private IScheduledFlightService scheduledFlightService;
	
	
	@PostMapping("/schedule-a-Flight")
	public ResponseEntity<ScheduledFlight> scheduleAFlight(@RequestBody ScheduledFlight scheduledFlight) throws Exception {
		if (scheduledFlight == null) {
			throw new Exception("Object is null");
		} else {
			return new ResponseEntity<ScheduledFlight>(scheduledFlightService.scheduleAFlight(scheduledFlight), HttpStatus.CREATED);
		}

	}
	@PutMapping("/modify-scheduledFlight")
	public ResponseEntity<ScheduledFlight> updateScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) throws Exception {
		if (scheduledFlight!= null) {
			return new ResponseEntity<ScheduledFlight>(scheduledFlightService.modifyScheduledFlight(scheduledFlight), HttpStatus.OK);
		}
		throw new Exception("Booking Object is null or empty");
	}

	@DeleteMapping("/delete-scheduledFlight/{scheduledFlightId}")
	public ResponseEntity<ScheduledFlight> deleteScheduledFlight(@PathVariable long scheduledFlightId) throws Exception {
		if (scheduledFlightId == 0) {
			throw new Exception("Booking Id is Invalid");
		}
		return new ResponseEntity<ScheduledFlight>(scheduledFlightService.deleteScheduledFlight(scheduledFlightId), HttpStatus.OK);
	}

	@GetMapping("/veiw-all-scheduledFlights")
	public ResponseEntity<List<ScheduledFlight>> viewScheduledFlights() throws ResourceNotFoundException {
		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightService.viewScheduledFlights(), HttpStatus.OK);
	}

	@GetMapping("/view-scheduledFlight-by-id/{scheduledFlightId}")
	public ResponseEntity<ScheduledFlight> viewScheduledFlight(@PathVariable long scheduledFlightId) throws Exception {
		if (scheduledFlightId == 0) {
			throw new Exception("Booking Id is Invalid");
		}
		return new ResponseEntity<ScheduledFlight>(scheduledFlightService.viewScheduledFlight(scheduledFlightId), HttpStatus.OK);
	}

}
