package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.models.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/Clientes")
	public List<Cliente> listar(){
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("José");
		cliente1.setEmail("emil@email.com");
		cliente1.setTelefone(null);
		
		return Arrays.asList(cliente1);
		
	}

}
