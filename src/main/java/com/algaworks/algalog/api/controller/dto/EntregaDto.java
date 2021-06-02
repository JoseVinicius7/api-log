package com.algaworks.algalog.api.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.algaworks.algalog.api.model.ClienteResumoModel;
import com.algaworks.algalog.domain.models.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaDto {
	
	private Long id;
	private ClienteResumoModel cliente;
	private DestinatarioDto destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private LocalDateTime dataPedido;
	private LocalDateTime dataFinalizacao;

}
