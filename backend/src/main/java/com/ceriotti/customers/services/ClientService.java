package com.ceriotti.customers.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceriotti.customers.dto.ClientDTO;
import com.ceriotti.customers.entities.Client;
import com.ceriotti.customers.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true) // Transactional garante que o método irá executar em uma transação com o banco de dados e o
									// "readOnly = true" evita o locking no banco de dados, assim melhorando a performance
	public List<ClientDTO> findAll() {
		List<Client> list = repository.findAll(); // Repository não mexe com DTO, apenas com a entidade. Assim, declara-se uma lista do tipo "Client"
		
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
		
		// Conversão de lista do tipo Client para o tipo ClientDTO
		// List<ClientDTO> listDto = new ArrayList<>() { 
		// for(Client cli : list) {
		//		listDto.add(new ClientDTO(cli));
		// }
		// return listDto;
		
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.get();
		return new ClientDTO(entity);
	}
	
}
