package com.projects.autodetailing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.autodetailing.entities.Order;
import com.projects.autodetailing.repositories.OrderRepository;

@Service
public class OrderServiceJPA {
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = orderRepository.findById(id);
		return obj.get();
	}

}
