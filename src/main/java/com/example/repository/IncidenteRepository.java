package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Incidente;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Integer>{
	
	
	@Query("select i from Incidente i where (?1 is -1 or i.codedificio.codedificio=?1) and (?2 is -1 or i.coddepartamento.coddepartamento=?2) and (?3 is -1 or i.estado=?3) and (?4 is -1 or i.codcausas.codcausas=?4)")
	public List<Incidente> listaIncidentePorEdiDepaEstaCausa(int codedificio, int coddepartamento, int estado, int codcausas);

}
