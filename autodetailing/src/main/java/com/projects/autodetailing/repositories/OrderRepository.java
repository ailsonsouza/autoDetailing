package com.projects.autodetailing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.autodetailing.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
