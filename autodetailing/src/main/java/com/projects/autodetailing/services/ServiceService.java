package com.projects.autodetailing.services;

import java.io.Serializable;
import java.util.List;

import com.projects.autodetailing.entities.Service;
import com.projects.autodetailing.repositories.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private final ServiceRepository serviceRepository;
	
	public ServiceService (ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}
	
	
	public List<Service> findAll(){
		return serviceRepository.findAll();
	}

}
