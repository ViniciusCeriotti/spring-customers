package com.ceriotti.customers.resources;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceriotti.customers.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		Instant date = Instant.now();
		List<Client> list = new ArrayList<>();
		list.add(new Client(1L, "Jose", "01111296575", 3200.00, date, 2));
		list.add(new Client(2L, "Joao", "02132075897", 4500.00, date, 6));
		return ResponseEntity.ok().body(list);
	}

}
