package com.projects.autodetailing.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
