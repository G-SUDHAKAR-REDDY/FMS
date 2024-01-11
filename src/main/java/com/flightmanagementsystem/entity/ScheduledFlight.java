package com.flightmanagementsystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class ScheduledFlight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long scheduleflightId;
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private Flight flight;
	private int availableSeats;
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private Schedule schedule;
	@ManyToOne
	@JoinColumn(name="airport_Id")
	private Airport airport;

}
