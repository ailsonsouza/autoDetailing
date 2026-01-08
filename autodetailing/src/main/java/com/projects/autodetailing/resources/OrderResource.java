package com.projects.autodetailing.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projects.autodetailing.entities.Order;
import com.projects.autodetailing.entities.OrderService;
import com.projects.autodetailing.services.OrderServiceJPA;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {
	
	@Autowired
	public OrderServiceJPA orderServiceJPA;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> allOrders = orderServiceJPA.findAll();
		return ResponseEntity.ok().body(allOrders);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = orderServiceJPA.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteOrder (@PathVariable Long id){
		orderServiceJPA.deleteOrder(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{orderId}/items/{itemId}")
    public ResponseEntity<Void> removeItemFromOrder(
            @PathVariable Long orderId, 
            @PathVariable Long itemId) {

		orderServiceJPA.removeServiceFromOrder(orderId, itemId);
        return ResponseEntity.noContent().build(); // Status 204
    }
	
	@PutMapping(value = "/{idOrder}/addServices/{serviceId}")
	public ResponseEntity<Order> addServices(@PathVariable Long idOrder,@PathVariable Long serviceId, @RequestBody OrderService orderService){
		Order orderToInsertService = orderServiceJPA.findById(idOrder);
		
		orderServiceJPA.addServiceToOrder(idOrder, serviceId, orderService);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idOrder}").buildAndExpand(orderToInsertService.getId()).toUri();
		return ResponseEntity.created(uri).body(orderToInsertService);
	}
	

}
