package com.flightmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagementsystem.entity.Client;
import com.flightmanagementsystem.exceptions.InvalidCredentials;
import com.flightmanagementsystem.exceptions.ResourceNotFoundException;
import com.flightmanagementsystem.service.IClientService;

@RestController
@RequestMapping( )
@CrossOrigin
public class ClientController {
	
	@Autowired
	private IClientService clientService;
	
	@PostMapping("/add-client")
	public ResponseEntity<Client> addClient(@RequestBody Client client) throws Exception {
		if (client == null) {
			throw new Exception("Object is null");
		} else {
			return new ResponseEntity<Client>(clientService.addClient(client), HttpStatus.CREATED);
		}

	}
	@PutMapping("/modify-client")
	public ResponseEntity<Client> updateClient(@RequestBody Client client) throws Exception {
		if (client!= null) {
			return new ResponseEntity<Client>(clientService.updateClient(client), HttpStatus.OK);
		}
		throw new Exception("Client Object is null or empty");
	}

	@DeleteMapping("/delete-client/{clientId}")
	public ResponseEntity<Client> deleteClient(@PathVariable long clientId) throws Exception {
		if (clientId == 0) {
			throw new Exception("Client Id is Invalid");
		}
		return new ResponseEntity<Client>(clientService.deleteClient(clientId), HttpStatus.OK);
	}

	@GetMapping("/veiw-all-clients")
	public ResponseEntity<List<Client>> viewClients() throws ResourceNotFoundException {
		return new ResponseEntity<List<Client>>(clientService.viewClients(), HttpStatus.OK);
	}

	@GetMapping("/view-client-by-id/{clientId}")
	public ResponseEntity<Client> viewClient(@PathVariable long clientId) throws Exception {
		if (clientId == 0) {
			throw new Exception("Client Id is Invalid");
		}
		return new ResponseEntity<Client>(clientService.viewClient(clientId), HttpStatus.OK);
	}

	@SuppressWarnings("unused")
	@GetMapping("/authenticate-client/{clientName}/{password}")
	public ResponseEntity<Client> validateClient(@PathVariable String clientName, @PathVariable String password)
			throws ResourceNotFoundException, InvalidCredentials {
		if (clientName == null && clientName == "" && password == null && password == "") 
		{
			throw new InvalidCredentials("Username and password is incorrect");
		} else {
			return new ResponseEntity<Client>(clientService.validateClient(clientName, password),
					HttpStatus.ACCEPTED);
		}
	}


}
