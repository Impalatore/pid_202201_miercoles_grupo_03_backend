package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Incidente;
import com.example.repository.IncidenteRepository;

@Service
public class IncidenteServiceImpl implements IncidenteService{
	
	@Autowired
	private IncidenteRepository repository;

	@Override
	public Incidente regitra(Incidente obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public Incidente actualiza(Incidente obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public List<Incidente> listaIncidente() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Incidente> listaIncidentePorEdiDepaEstaCausa(int codedificio, int coddepartamento, int estado,
			int codcausas) {
		// TODO Auto-generated method stub
		return repository.listaIncidentePorEdiDepaEstaCausa(codedificio, coddepartamento, estado, codcausas);
	}

}
