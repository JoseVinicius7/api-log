package com.algaworks.algalog.api.exception;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
