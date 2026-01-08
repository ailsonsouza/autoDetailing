package com.projects.autodetailing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.projects.autodetailing.entities.Client;
import com.projects.autodetailing.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	public List<Client> findAll(){
		return clientRepository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.orElseThrow( () -> new RuntimeException());
	}
	
	public void insert(Client client) {
		clientRepository.save(client);		
	}
	
	public void delete(Long id) {
		try {
			clientRepository.deleteById(id);			
		}catch(DataIntegrityViolationException e) {
			throw new RuntimeException (e.getMessage());
		}
	}
	
	public void update(Long id, Client clientUpdated) {
		Client client = clientRepository.getReferenceById(id);
		updateClient(client, clientUpdated);
		clientRepository.save(client);
		
	}
	
	private void updateClient(Client client, Client clientUpdated) {
		client.setAddress(clientUpdated.getAddress());
		client.setBirthday(clientUpdated.getBirthday());
		client.setCpf(clientUpdated.getCpf());
		client.setName(clientUpdated.getName());
		client.setTelephoneNumber(clientUpdated.getTelephoneNumber());
	}

}
