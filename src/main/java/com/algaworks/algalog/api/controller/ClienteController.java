package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.models.Cliente;

@RestController
public class ClienteController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("/Clientes")
	public List<Cliente> listar(){
		
	 
		return null;
	}

}
