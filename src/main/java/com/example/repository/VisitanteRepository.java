package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Visitante;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Integer>{

	// Con JpaRRepository ya se heredaron todos los metodos(DML)
}
