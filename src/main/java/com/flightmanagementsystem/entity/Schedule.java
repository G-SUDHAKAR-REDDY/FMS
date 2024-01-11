package com.flightmanagementsystem.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Schedule {
	 @Id
	 private long scheduleId;
	 private LocalDateTime arrivalTime;
	 private LocalDateTime departureTime;
	 @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	 private Airport sourceAirport;
	 @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	 private Airport destinationAirport;
	 

}
