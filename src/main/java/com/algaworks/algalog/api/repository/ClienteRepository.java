package com.algaworks.algalog.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algalog.api.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
