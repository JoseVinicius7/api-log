package com.algaworks.algalog.domain.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude (Include.NON_NULL)
@Getter
@Setter
public class ApiError {
	
	int status;
	LocalDateTime data;
	String titulo;
	List<Campos> campos;
	
	@Getter
	@AllArgsConstructor
	public static class Campos {
		String nome;
		String mensagem;
	}
	
}
