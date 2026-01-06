package com.projects.autodetailing.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.autodetailing.entities.Client;
import com.projects.autodetailing.services.ClientService;

@RestController
@RequestMapping(value= "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> allClients =  clientService.findAll();
		return ResponseEntity.ok().body(allClients);
	}
	

}
