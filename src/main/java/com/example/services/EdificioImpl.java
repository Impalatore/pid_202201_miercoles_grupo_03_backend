package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Edificio;
import com.example.repository.EdificioRepository;

@Service
public class EdificioImpl implements EdificioService{

	@Autowired
	private EdificioRepository repository;
	
	@Override
	public Edificio inserta(Edificio obj) {
		
		return repository.save(obj);
	}

	@Override
	public List<Edificio> listaEdificio() {
		
		return repository.findAll();
	}

}
