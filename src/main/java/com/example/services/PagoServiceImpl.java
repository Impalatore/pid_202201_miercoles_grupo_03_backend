package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Pago;
import com.example.repository.PagoRepository;

@Service
public class PagoServiceImpl implements PagoService {
    
	@Autowired
	private PagoRepository repo;
	@Override
	public Pago insertaActualizaPago(Pago obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}
	@Override
	public List<Pago> listaxtodos() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
