package com.example.services;

import java.util.List;

import com.example.entity.Visita;

public interface VisitaService {

	public abstract Visita registra(Visita obj);
	
	public abstract List<Visita> listaVisita();
	
	public abstract List<Visita> listaVisitaxDNINOMBRE(String nombre, String dni);
}
