package com.flightmanagementsystem.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmanagementsystem.entity.ScheduledFlight;
import com.flightmanagementsystem.exceptions.FlightAlreadyExistsException;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;
import com.flightmanagementsystem.repository.IAirportRepository;
import com.flightmanagementsystem.repository.IScheduledFlightRepository;
import com.flightmanagementsystem.service.IScheduledFlightService;
@Service
public class IScheduledFlightServiceImpl implements IScheduledFlightService{
	
	@Autowired
	private IScheduledFlightRepository scheduledFlightRepository;
	
	@Autowired
	private IAirportRepository airportRepository;

	@Override
	public ScheduledFlight scheduleAFlight(ScheduledFlight scheduledFlight) throws FlightAlreadyExistsException  {
		Optional<ScheduledFlight> sf=scheduledFlightRepository.findById(scheduledFlight.getScheduleflightId());
		if (sf.isPresent()) {
			throw new FlightAlreadyExistsException(" Flight already scheduled with Id " + scheduledFlight.getScheduleflightId());
		} else {
			return scheduledFlightRepository.save(scheduledFlight);
		}

					
	}

	@Override
	public ScheduledFlight viewScheduledFlight(long scheduledFlightId) throws ResourceNotFoundException {
		
		return scheduledFlightRepository.findById(scheduledFlightId)
				.orElseThrow(() -> new ResourceNotFoundException("Flight not available with this Id"));
	}

	@Override
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight) throws ResourceNotFoundException {
		
    ScheduledFlight sft = scheduledFlightRepository.findById(scheduledFlight.getScheduleflightId())
				.orElseThrow(() -> new ResourceNotFoundException("ScheduledFlight Details are not found"));
    
    sft.setFlight(scheduledFlight.getFlight());
    sft.setSchedule(scheduledFlight.getSchedule());
    sft.setScheduleflightId(scheduledFlight.getScheduleflightId());
    sft.setAvailableSeats(scheduledFlight.getAvailableSeats());
    
    return scheduledFlightRepository.save(sft);
	}

	@Override
	public ScheduledFlight deleteScheduledFlight(long scheduledFlightId) throws ResourceNotFoundException {
		
		ScheduledFlight ft = scheduledFlightRepository.findById(scheduledFlightId)
				.orElseThrow(() -> new ResourceNotFoundException("Flight Not Found in the database"));
		scheduledFlightRepository.delete(ft);
		return ft;
	}

	@Override
	public List<ScheduledFlight> viewScheduledFlights() throws ResourceNotFoundException {
		
		List<ScheduledFlight> list = scheduledFlightRepository.findAll();
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("ScheduledFlights are not there in the database");
		} else {
			return list;
		}
	}

}
