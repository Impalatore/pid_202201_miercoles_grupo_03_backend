package com.example.services;

import java.util.List;

import com.example.entity.Boleta;

public interface BoletaService {

	public abstract List<Boleta> listaxdnixnombre(String dni,String nombre); 
   
	public Boleta insertaActualizaBoleta(Boleta obj);
	
	public abstract List<Boleta> listaxtodos();
}
