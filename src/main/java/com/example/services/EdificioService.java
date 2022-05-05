package com.example.services;

import java.util.List;

import com.example.entity.Edificio;

public interface EdificioService {
	
public abstract Edificio inserta(Edificio obj);
	
	public abstract List<Edificio> listaEdificio();
}
