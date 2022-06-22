package com.example.services;

import java.util.List;

import com.example.entity.Visitante;

public interface VisitanteService {

	public abstract Visitante insertaActualizaVisitante(Visitante obj);
	
	public abstract List<Visitante> listaVisitante();
	
    public abstract List<Visitante> listaxDni(String dni);	
}
