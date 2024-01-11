package com.flightmanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clientId;
	private String clientType;
	private String clientName;
	private Password clientPassword;
	private long clientPhoneNumber;
	private String email;
	
	
}
