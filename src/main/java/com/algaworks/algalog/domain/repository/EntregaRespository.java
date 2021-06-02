package com.algaworks.algalog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.domain.models.Entrega;

@Repository
public interface EntregaRespository extends JpaRepository<Entrega, Long> {

}
