package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.models.Entrega;
import com.algaworks.algalog.domain.models.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {
	
	private BuscarEntregaService buscarEntregaService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaid, String descricao) {
		Entrega entrega = buscarEntregaService.buscar(entregaid);
		
		return entrega.adicionarOcorrencia(descricao);
		
		
	}
}
