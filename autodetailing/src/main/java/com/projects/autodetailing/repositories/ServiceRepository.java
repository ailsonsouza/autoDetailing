package com.projects.autodetailing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.autodetailing.entities.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long>{

}
