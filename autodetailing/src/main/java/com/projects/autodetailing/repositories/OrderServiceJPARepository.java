package com.projects.autodetailing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.autodetailing.entities.OrderService;
import com.projects.autodetailing.entities.PK.OrderServicePK;

public interface OrderServiceJPARepository extends JpaRepository<OrderService, OrderServicePK>{

}
