package com.pispl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pispl.model.Client;
import com.pispl.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	//Return list of Clients
	public List<Client> getClients()
	{
		return clientRepository.findAll();
	}
	
	// Save new Client
	public void save(Client client)
	{
		clientRepository.save(client);
	}
	
	//get by id
	public Optional<Client> findById(int id)
	{
		return clientRepository.findById(id);
	}

	public void delete(Integer id) {
		clientRepository.deleteById(id);
		
	}
}
