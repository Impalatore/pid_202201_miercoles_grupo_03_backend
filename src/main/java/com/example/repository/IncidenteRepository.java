package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Incidente;

public interface IncidenteRepository extends JpaRepository<Incidente, Integer>{

	// Con JpaRRepository ya se heredaron todos los metodos(DML)
}
