package com.example.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Visitante;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Integer>{

	public List<Visitante>findByDni(String dni);
}
