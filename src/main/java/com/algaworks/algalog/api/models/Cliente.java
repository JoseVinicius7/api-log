package com.algaworks.algalog.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.algaworks.algalog.api.ValidacaoGroups;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Cliente {
	
	@NotNull (groups = ValidacaoGroups.ClienteId.class)
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	@Size (max = 60)
	private String nome;
	
	@NotBlank @Email
	@Size (max = 255)
	private String email;
	
	@Size(max = 11)
	@Column(name = "fone")
	private String telefone;
	
	
}
