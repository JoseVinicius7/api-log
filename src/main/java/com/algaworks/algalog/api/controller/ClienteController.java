package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.models.Cliente;
import com.algaworks.algalog.api.repository.ClienteRepository;
import com.algaworks.algalog.api.service.ClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteRepository clienteRepository;
	
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listar() {

		return clienteRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@Valid @PathVariable Long id) {
		return clienteRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	
	}
	
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public Cliente cadastrar(@Valid @RequestBody Cliente cliente){
//		return clienteRepository.save(cliente);
		return clienteService.salvar(cliente);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Cliente> atualizar (@Valid @RequestBody Cliente cliente, @PathVariable Long id){
		
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(id);
		cliente =  clienteRepository.save(cliente);
		
		return ResponseEntity.ok(cliente);	
		
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<Void> remover (@Valid @PathVariable Long id) {
		
		if(!clienteRepository.existsById(id)) {
			ResponseEntity.notFound().build();
		}
		clienteService.deleta(id);
		
		return ResponseEntity.noContent().build();

	}
	
}
