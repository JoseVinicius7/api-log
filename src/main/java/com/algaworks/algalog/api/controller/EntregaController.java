package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.assembler.EntregaAssembler;
import com.algaworks.algalog.api.controller.dto.EntregaDto;
import com.algaworks.algalog.api.model.input.EntregaInput;
import com.algaworks.algalog.domain.models.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRespository;
import com.algaworks.algalog.domain.service.FinalizarEntregaService;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private EntregaRespository entregaRespository;
	private SolicitacaoEntregaService entregaService;
	private EntregaAssembler assembler;
	private FinalizarEntregaService finalizarEntregaService ;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDto solicitacao(@Valid @RequestBody EntregaInput entregaInput){
		
		Entrega novaEntrega = assembler.toEntity(entregaInput);
		Entrega solicitar = entregaService.solicitacao(novaEntrega);
		
		return assembler.entregaDto(solicitar);
	}
	
	@GetMapping
	public List<EntregaDto> listar (Entrega entrega){
		return assembler.toCollectionDto(entregaRespository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntregaDto> buscar (@PathVariable Long id){
		return entregaRespository.findById(id)
				.map(entrega -> ResponseEntity.ok(assembler.entregaDto(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar (@PathVariable Long entregaId) {
		finalizarEntregaService.finalizar(entregaId);
	}
}
