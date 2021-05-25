package com.algaworks.algalog.api.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {
	
	int status;
	LocalDateTime data;
	String titulo;
	
	@Getter
	@AllArgsConstructor
	public static class Campos {
		String nome;
		String mensagem;
	}
	
}
