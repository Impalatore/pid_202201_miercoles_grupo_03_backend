package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Visita;
import com.example.repository.VisitaRepository;

@Service
public class VisitaImpl implements VisitaService{

	@Autowired
	VisitaRepository repositoryVisi;
	
	@Override
	public Visita registra(Visita obj) {
		
		return repositoryVisi.save(obj);
	}

	@Override
	public List<Visita> listaVisita() {
		// TODO Auto-generated method stub
		return repositoryVisi.findAll();
	}

	@Override
	public List<Visita> listaVisitaPorVisitanteDepartamento(int codvisitantes, int coddepartamento, int estado) {
		// TODO Auto-generated method stub
		return repositoryVisi.listaVisitaPorVisitanteDepartamento(codvisitantes, coddepartamento, estado);
	}

	@Override
	public Visita actualiza(Visita obj) {
		// TODO Auto-generated method stub
		return repositoryVisi.save(obj);
	}

	@Override
	public List<Visita> listaVisitaPorVisitanteEstado(int estado) {
		// TODO Auto-generated method stub
		return repositoryVisi.listaVisitaPorVisitanteEstado( estado);
	}

}
