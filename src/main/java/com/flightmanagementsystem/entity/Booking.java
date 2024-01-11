package com.flightmanagementsystem.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;
	private double ticketCost;
	private LocalDateTime bookingDate;
	private long noofPassengers;
	@OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private List<Passenger> passengerlist;
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private Flight flight;
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private Client client;

}
