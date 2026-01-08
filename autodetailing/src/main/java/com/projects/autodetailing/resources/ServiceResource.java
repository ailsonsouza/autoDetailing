package com.projects.autodetailing.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projects.autodetailing.entities.ServiceEntity;
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
	public ResponseEntity<List<ServiceEntity>> findAll(){
		List<ServiceEntity> serviceEntity = serviceService.findAll();
		return ResponseEntity.ok(serviceEntity);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ServiceEntity> findById(@PathVariable long id) {
		return ResponseEntity.ok(serviceService.findById(id));
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ServiceEntity> updateService(@PathVariable long id, @RequestBody ServiceEntity serviceEntity){
		ServiceEntity serviceEntityUpdated = serviceService.updateService(id, serviceEntity);
		return ResponseEntity.ok(serviceEntityUpdated);
	}	
	
	@PostMapping
	public ResponseEntity<ServiceEntity> insertService(@RequestBody ServiceEntity serviceEntity){
		serviceService.insertService(serviceEntity);
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(serviceEntity.getId()).toUri()).body(serviceEntity);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteService(@PathVariable long id){
		serviceService.deleteService(id);
		return ResponseEntity.noContent().build();
	}
	
	

	

}
