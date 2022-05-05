package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Propietario;
import com.example.repository.PropietarioRepository;

@Service
public class PropietarioServiceImpl implements PropietarioService{
	
	@Autowired
	private PropietarioRepository repository;

	@Override
	public List<Propietario> listaPropietario() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Propietario insertaActualizaPropietario(Propietario obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public Propietario EliminarCambiarEstadoPropietario(Propietario obj) {
		
		return repository.save(obj);
	}

}
