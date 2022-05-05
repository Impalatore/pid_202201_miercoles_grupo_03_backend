package com.example.services;

import java.util.List;

import com.example.entity.Incidente;

public interface IncidenteService {
	
	public abstract Incidente insertaActualiza(Incidente obj);
	
	public abstract List<Incidente> listaIncidente();

}
