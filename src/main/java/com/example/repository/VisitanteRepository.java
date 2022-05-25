package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Visitante;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Integer>{

	// Con JpaRRepository ya se heredaron todos los metodos(DML)
	
	// JPQL
		// Query no con tablas sino con clases que tienen @Entity
		@Query("select v from Visitante v where v.dni = ?1")
		public List<Visitante> listaVisitantePorDNI(String dni);
}
