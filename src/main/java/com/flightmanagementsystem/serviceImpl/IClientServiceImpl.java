package com.flightmanagementsystem.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmanagementsystem.entity.Client;
import com.flightmanagementsystem.exceptions.ClientAlreadyExistsException;
import com.flightmanagementsystem.exceptions.InvalidCredentials;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;
import com.flightmanagementsystem.repository.IClientRepository;
import com.flightmanagementsystem.service.IClientService;

@Service
public class IClientServiceImpl implements IClientService {

	@Autowired
	private IClientRepository clientRepository;

	@Override
	public Client addClient(Client client) throws ClientAlreadyExistsException {

		Optional<?> c = clientRepository.getClientByName(client.getClientName());
		Client cl = null;
		if (c.isPresent()) {
			throw new ClientAlreadyExistsException("Client already exists with client name " + client.getClientName());
		} else {
			cl = clientRepository.save(client);
		}

		return cl;
	}

	@Override
	public Client updateClient(Client client) throws ResourceNotFoundException {
		Client ct = clientRepository.findById(client.getClientId())
				.orElseThrow(() -> new ResourceNotFoundException("Client Details are not found"));

		ct.setClientId(client.getClientId());
		ct.setClientName(client.getClientName());
		ct.setClientType(client.getClientType());
		ct.setClientPhoneNumber(client.getClientPhoneNumber());
		ct.setEmail(client.getEmail());
		ct.setClientPassword(client.getClientPassword());
		return clientRepository.save(ct);

	}

	@Override
	public Client viewClient(long clientId) throws ResourceNotFoundException {
		return clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client Not Found in the database"));

	}

	@Override
	public Client validateClient(String clientName, String password)
			throws InvalidCredentials, ResourceNotFoundException {
		Client c2 = clientRepository.getClientByClientname(clientName)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Credentials"));
		if (c2.getClientName().equalsIgnoreCase(clientName) && c2.getClientPassword().equals(password)) {
			return c2;
		} else {
			throw new InvalidCredentials("ClientName or password is Invalid");
		}
	}

	@Override
	public Client deleteClient(long clientId) throws ResourceNotFoundException {

		Client c1 = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("client Not Found in the database"));
		clientRepository.delete(c1);
		return c1;
	}

	@Override
	public List<Client> viewClients() throws ResourceNotFoundException {

		List<Client> list = clientRepository.findAll();
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("No clients are there in the database");
		} else {
			return list;
		}
	}

}
