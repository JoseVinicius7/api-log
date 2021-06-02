package com.algaworks.algalog.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.api.models.Entrega;

@Repository
public interface EntregaRespository extends JpaRepository<Entrega, Long> {

}
