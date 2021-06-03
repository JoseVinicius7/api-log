package com.algaworks.algalog.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

import com.algaworks.algalog.domain.ValidacaoGroups;
import com.algaworks.algalog.domain.exception.BusinessException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ConvertGroup (from = Default.class, to = ValidacaoGroups.ClienteId.class)
	@Valid
	@NotNull
	@ManyToOne
	private Cliente cliente;
	
	
	@Embedded
	private Destinatario destinatario;
	
	
	@NotNull
	private BigDecimal taxa;
	
	@OneToMany(mappedBy = "entrega",cascade = CascadeType.ALL)
	List<Ocorrencia> ocorrencia = new ArrayList<>();
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusEntrega status;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dataPedido;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dataFinalizacao;

	public Ocorrencia adicionarOcorrencia(String descricao) {
		Ocorrencia ocorrencia = new Ocorrencia();
				ocorrencia.setDescricao(descricao);
				ocorrencia.setDataRegistro(LocalDateTime.now());
				ocorrencia.setEntrega(this);
				
		this.getOcorrencia().add(ocorrencia);
				
		return ocorrencia;
	}
	
	public void finalizar () {
		if(naoPodeSerFinalizado()){
			throw new BusinessException("Entrega não pode ser finalizada!");
		}
		setStatus(StatusEntrega.FINALIZADA);
		setDataFinalizacao(LocalDateTime.now());
	}

	public boolean podeserfinalizado() {
		return StatusEntrega.PENDENTE.equals(getStatus());
	}
	public boolean naoPodeSerFinalizado() {
		return !podeserfinalizado();
	}
	


}
