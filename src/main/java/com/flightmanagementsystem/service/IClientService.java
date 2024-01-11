package com.flightmanagementsystem.service;

import java.util.List;

import com.flightmanagementsystem.entity.Client;
import com.flightmanagementsystem.exceptions.ClientAlreadyExistsException;
import com.flightmanagementsystem.exceptions.InvalidCredentials;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;

public interface IClientService {

	public Client addClient(Client client) throws ClientAlreadyExistsException;
	public Client viewClient(long clientId) throws ResourceNotFoundException;
	public Client updateClient(Client client) throws ResourceNotFoundException;
	public Client validateClient(String clientName, String password) throws InvalidCredentials, ResourceNotFoundException;
	public Client deleteClient(long clientId) throws ResourceNotFoundException;
	public List<Client> viewClients() throws ResourceNotFoundException;
}
