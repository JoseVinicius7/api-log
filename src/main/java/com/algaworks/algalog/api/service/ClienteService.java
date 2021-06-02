package com.algaworks.algalog.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.api.exception.BusinessException;
import com.algaworks.algalog.api.models.Cliente;
import com.algaworks.algalog.api.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	public Cliente salvar (Long clienteId) {
		return clienteRepository.findById(clienteId)
				.orElseThrow(()-> new BusinessException ("Cliente não Encontrado"));
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !equals(cliente));
		
		if (emailEmUso) {
			throw new BusinessException("Email já cadastrado");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void deleta (Long id) {
		clienteRepository.deleteById(id);
	}
	
	
}
