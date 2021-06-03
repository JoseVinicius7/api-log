package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algalog.domain.models.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRespository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscarEntregaService {
	
	private EntregaRespository entregaRespository;
	
	public Entrega buscar(Long entregaid) {
		return entregaRespository.findById(entregaid)
				.orElseThrow(()-> new EntidadeNaoEncontradaException("Entrega não localizada"));
	}
}
