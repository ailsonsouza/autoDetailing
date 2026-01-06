package com.projects.autodetailing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.autodetailing.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Long>{

}
