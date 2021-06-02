package com.algaworks.algalog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.controller.dto.EntregaDto;
import com.algaworks.algalog.api.model.input.EntregaInput;
import com.algaworks.algalog.domain.models.Entrega;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaAssembler {

	private ModelMapper modelMapper;

	public EntregaDto entregaDto(Entrega entrega) {

		return modelMapper.map(entrega, EntregaDto.class);
	}

	public List<EntregaDto> toCollectionDto(List<Entrega> entrega) {
		return entrega.stream().map(this::entregaDto).collect(Collectors.toList());

	}

	public Entrega toEntity(EntregaInput entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}
}
