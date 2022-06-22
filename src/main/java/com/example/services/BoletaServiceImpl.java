package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Boleta;
import com.example.repository.BoletaRepository;

@Service
public class BoletaServiceImpl implements BoletaService {
	
	@Autowired
	private BoletaRepository repo;

	@Override
	public List<Boleta> listaxdnixnombre(String dni, String nombre) {
		// TODO Auto-generated method stub
		return repo.listaBoletaporDniyNombre(nombre, dni);
	}

	@Override
	public Boleta insertaActualizaBoleta(Boleta obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Boleta> listaxtodos() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
