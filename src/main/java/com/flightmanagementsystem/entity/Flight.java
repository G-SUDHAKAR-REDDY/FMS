package com.flightmanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Flight {
	@Id
	private long flightNumber;
	private String carrierName;
	private String flightModel;
	private int seatCapacity;
}
