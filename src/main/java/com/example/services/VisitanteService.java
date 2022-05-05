package com.example.services;

import java.util.List;

import com.example.entity.Visitante;

public interface VisitanteService {

	public abstract Visitante inserta(Visitante obj);
	
	public abstract List<Visitante> listaVisitante();
	
}
