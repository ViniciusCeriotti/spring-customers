package com.ceriotti.customers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriotti.customers.entities.Client;
import com.ceriotti.customers.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true) // Transactional garante que o método irá executar em uma transação com o banco de dados e o
									// "readOnly = true" evita o locking no banco de dados, assim melhorando a performance
	public List<Client> findAll() {
		return repository.findAll();
	}
	
}
