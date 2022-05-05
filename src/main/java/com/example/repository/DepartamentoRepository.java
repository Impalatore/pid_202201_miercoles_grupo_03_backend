package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{

	// Con JpaRRepository ya se heredaron todos los metodos(DML)
}
