package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Servicio;
import com.example.repository.ServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioService {
    @Autowired
	private ServicioRepository repo;
	
	@Override
	public List<Servicio> listaServicio() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
