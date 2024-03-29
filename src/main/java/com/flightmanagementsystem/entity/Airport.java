package com.flightmanagementsystem.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long airportId;
	private String airportName;
	private String airportLocation;
	private String airportCode;

}
