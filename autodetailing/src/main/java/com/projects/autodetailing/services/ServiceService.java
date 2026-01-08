package com.projects.autodetailing.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projects.autodetailing.entities.ServiceEntity;
import com.projects.autodetailing.repositories.ServiceRepository;

@Service
public class ServiceService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final ServiceRepository serviceRepository;
	
	public ServiceService (ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}
	
	public List<ServiceEntity> findAll(){
		return serviceRepository.findAll();
	}
	
	public ServiceEntity findById(long id) {
		Optional<ServiceEntity> serviceEntity = serviceRepository.findById(id);
		return serviceEntity.orElseThrow(() -> new RuntimeException());
	}
	
	public void insertService(ServiceEntity serviceEntity) {
		serviceRepository.save(serviceEntity);
	}
	
	public ServiceEntity updateService(Long id, ServiceEntity serviceEntity) {
		if (serviceEntity != null) {
			ServiceEntity serviceEntityToUpdate = serviceRepository.getReferenceById(id);
			updatingServiceData(serviceEntityToUpdate, serviceEntity); 
			serviceRepository.save(serviceEntityToUpdate);
			return serviceEntityToUpdate;
		}else{throw new IllegalArgumentException("The update data cannot be null.");}
	}
	
	
	public void deleteService(Long id) {
		if (id != null) {
			 serviceRepository.deleteById(id);
		}else{throw new RuntimeException();}
	}
	
	
	public ServiceEntity updatingServiceData(ServiceEntity serviceEntityToUpdate, ServiceEntity serviceEntity) {
		serviceEntityToUpdate.setNameService(serviceEntity.getNameService());
		serviceEntityToUpdate.setPrice(serviceEntity.getPrice());
		return serviceEntityToUpdate;
	}

}
