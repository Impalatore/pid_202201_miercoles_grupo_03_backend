package com.example.services;

import java.util.List;

import com.example.entity.Visita;

public interface VisitaService {

	public abstract Visita registra(Visita obj);
	
	public abstract Visita actualiza(Visita obj);
	
	public abstract List<Visita> listaVisita();
	
	public List<Visita> listaVisitaPorVisitanteDepartamento(int codvisitantes, int coddepartamento, int estado);
	
	public List<Visita> listaVisitaPorVisitanteEstado( int estado);
	
}
