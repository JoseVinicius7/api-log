package com.algaworks.algalog.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algalog.api.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Optional<Cliente> findByEmail (String email);

}
