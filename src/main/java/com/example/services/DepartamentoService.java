package com.example.services;

import java.util.List;

import com.example.entity.Departamento;

public interface DepartamentoService {

	public abstract Departamento insertaActualiza(Departamento obj);
	
	public abstract List<Departamento> listaDepartamento();
}
