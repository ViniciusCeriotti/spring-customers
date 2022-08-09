package com.ceriotti.customers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceriotti.customers.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
