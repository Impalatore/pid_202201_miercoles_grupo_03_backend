package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Visita;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Integer>{

	// JPQL
	// Query no con tablas sino con clases que tienen @Entity
	@Query("select v from Visita v where (?1 is -1 or v.codvisitantes.codvisitantes=?1) and (?2 is -1 or v.coddepartamento.coddepartamento=?2) and v.estado=?3")
	public List<Visita> listaVisitaPorVisitanteDepartamento(int codvisitantes, int coddepartamento, int estado);
	
	@Query("select v from Visita v where  v.estado=1")
    public List<Visita> listaVisitaPorVisitanteEstado( int estado);
}
