package com.flightmanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Passenger {
	@Id
	private long pnrNumber;
	private String passengerName;
	private int passengerAge;
	private long passengerUIN;
	private double luggage;

}
