package com.flightmanagementsystem.service;

import java.util.List;

import com.flightmanagementsystem.entity.ScheduledFlight;
import com.flightmanagementsystem.exceptions.FlightAlreadyExistsException;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;

public interface IScheduledFlightService {

	public ScheduledFlight scheduleAFlight(ScheduledFlight scheduledFlight) throws  FlightAlreadyExistsException;
	public ScheduledFlight viewScheduledFlight(long scheduledFlightId) throws ResourceNotFoundException;
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight) throws ResourceNotFoundException;
	public ScheduledFlight deleteScheduledFlight(long scheduledFlightId) throws ResourceNotFoundException;
	public List<ScheduledFlight> viewScheduledFlights() throws ResourceNotFoundException;
}
