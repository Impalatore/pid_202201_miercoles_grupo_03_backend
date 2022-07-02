package com.example.services;

import java.util.List;

import com.example.entity.Incidente;

public interface IncidenteService {
	
	public abstract Incidente regitra(Incidente obj);
	
	public abstract Incidente actualiza(Incidente obj);
	
	public abstract List<Incidente> listaIncidente();
	
	public List<Incidente> listaIncidentePorEdiDepaEstaCausa(int codedificio, int coddepartamento, int estado, int codcausas); 

}
