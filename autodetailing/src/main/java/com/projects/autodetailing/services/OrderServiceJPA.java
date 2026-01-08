package com.projects.autodetailing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import com.projects.autodetailing.emuns.OrderStatus;
import com.projects.autodetailing.entities.Order;
import com.projects.autodetailing.entities.OrderService;
import com.projects.autodetailing.entities.ServiceEntity;
import com.projects.autodetailing.entities.PK.OrderServicePK;
import com.projects.autodetailing.repositories.OrderRepository;
import com.projects.autodetailing.repositories.OrderServiceJPARepository;
import com.projects.autodetailing.repositories.ServiceRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceJPA {

	private final OrderRepository orderRepository;
	private final ServiceRepository serviceRepository;
	private final OrderServiceJPARepository orderServiceJPARepository;
	

	public OrderServiceJPA(OrderRepository orderRepository, ServiceRepository serviceRepository, OrderServiceJPARepository orderServiceJPARepository) {
		this.orderRepository = orderRepository;
		this.serviceRepository = serviceRepository;
		this.orderServiceJPARepository = orderServiceJPARepository;
	}

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = orderRepository.findById(id);
		return obj.get();
	}

	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}

	@Transactional
	public void removeServiceFromOrder(Long orderId, Long serviceId) {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));

		boolean removed = order.getServices().removeIf(item -> item.getId().getService().getId().equals(serviceId));

		if (!removed) {
			throw new ResourceNotFoundException("Serviço não encontrado neste pedido");
		}

		orderRepository.save(order);
	}
	
	@Transactional
	public OrderService addServiceToOrder(Long orderId, Long serviceId, OrderService orderService) {
		
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
		
		ServiceEntity serviceEntity = serviceRepository.findById(serviceId).orElseThrow(() -> new ResourceNotFoundException("Service not found"));
		OrderStatus orderStatus = order.getOrderStatus();
		
		if (orderStatus == OrderStatus.IN_PROGRESS) {
			OrderServicePK pk = new OrderServicePK();
			
			pk.setOrder(order);
			pk.setService(serviceEntity);
			
			//OrderService orderService = new OrderService();
			
			orderService.setId(pk);
			orderService.setQuantity(orderService.getQuantity());
			orderService.setPrice(orderService.getPrice());
			
			return orderServiceJPARepository.save(orderService);			
		}else {
			throw new RuntimeException("The order status isn't in progress");
		}
		
	}
	
	
	
}
