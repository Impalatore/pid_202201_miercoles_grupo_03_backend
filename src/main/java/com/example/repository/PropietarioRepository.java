package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Propietario;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Integer>{

	// Con JpaRRepository ya se heredaron todos los metodos(DML)
}
