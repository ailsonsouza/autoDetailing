package com.projects.autodetailing.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.autodetailing.entities.Service;
import com.projects.autodetailing.services.ServiceService;

@RestController
@RequestMapping(value= "/services")
public class ServiceResource implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public final ServiceService serviceService;
	
	public ServiceResource(ServiceService serviceService) {
		this.serviceService = serviceService;
	}
	
	@GetMapping
	public ResponseEntity<List<Service>> findAll(){
		return ResponseEntity.ok(serviceService.findAll());
	}
	

}
