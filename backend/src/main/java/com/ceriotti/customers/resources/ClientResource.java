package com.ceriotti.customers.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceriotti.customers.entities.Client;
import com.ceriotti.customers.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		//Instant date1 = Instant.now();
		//Instant date2 = Instant.parse("1970-01-01T00:00:00Z");
		List<Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
