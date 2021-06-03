package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.models.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRespository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FinalizarEntregaService {

	private EntregaRespository entregaRespository;
	private BuscarEntregaService buscarEntregaService;

	@Transactional
	public void finalizar(Long entregaId) {
		Entrega entrega = buscarEntregaService.buscar(entregaId);

		entrega.finalizar();

		entregaRespository.save(entrega);

	}

}
