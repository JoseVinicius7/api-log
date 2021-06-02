package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.models.Entrega;
import com.algaworks.algalog.api.repository.EntregaRespository;
import com.algaworks.algalog.api.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private EntregaRespository entregaRespository;
	private SolicitacaoEntregaService entregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitacao(@Valid @RequestBody Entrega entrega){
		return entregaService.solicitacao(entrega);
	}
	
	@GetMapping
	public List<Entrega> listar (Entrega entrega){
		return entregaRespository.findAll();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Entrega> buscar (@PathVariable Long id){
		return entregaRespository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	
}
