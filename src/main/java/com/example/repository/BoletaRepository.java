package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Boleta;

@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Integer>{

	@Query(" select b from Boleta b where"
			+ " ( :p_nom is '' or b.codpropietario.nombre =    :p_nom) and"
			+ " ( :p_dni is '' or b.codpropietario.dni     =   :p_dni    ) ")
	public List<Boleta> listaBoletaporDniyNombre(@Param("p_nom") String nombre,
			                                     @Param("p_dni") String dni);
			
	
	
}
