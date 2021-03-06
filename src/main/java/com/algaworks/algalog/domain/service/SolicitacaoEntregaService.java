package com.algaworks.algalog.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.models.Cliente;
import com.algaworks.algalog.domain.models.Entrega;
import com.algaworks.algalog.domain.models.StatusEntrega;
import com.algaworks.algalog.domain.repository.EntregaRespository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private ClienteService clienteService;
	private EntregaRespository entregaRespository;
	
	@Transactional
	public Entrega solicitacao (Entrega entrega) {
		Cliente cliente = clienteService.salvar(entrega.getCliente().getId());
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());		
		
		return entregaRespository.save(entrega);
	}
	
}
