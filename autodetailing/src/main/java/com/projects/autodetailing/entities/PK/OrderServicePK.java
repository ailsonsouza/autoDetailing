package com.projects.autodetailing.entities.PK;

import java.io.Serializable;
import java.util.Objects;

import com.projects.autodetailing.entities.Order;
import com.projects.autodetailing.entities.Service;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderServicePK  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Service getService() {
		return service;
	}
	
	public void setService(Service service) {
		this.service = service;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(order, service);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderServicePK other = (OrderServicePK) obj;
		return Objects.equals(order, other.order) && Objects.equals(service, other.service);
	}
	
	
	
	
	
	
	

}
