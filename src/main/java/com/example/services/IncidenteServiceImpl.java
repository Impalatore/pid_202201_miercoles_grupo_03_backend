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
	public Incidente insertaActualiza(Incidente obj) {
		
		return repository.save(obj);
	}

	@Override
	public List<Incidente> listaIncidente() {
		
		return repository.findAll();
	}

}
