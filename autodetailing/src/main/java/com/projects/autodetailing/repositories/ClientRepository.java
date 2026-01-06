package com.projects.autodetailing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.autodetailing.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
