package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Causas;
import com.example.repository.CausaRepository;

@Service
public class CausaServiceImpl implements CausaService{
	
	@Autowired
	private CausaRepository repository;

	@Override
	public List<Causas> listaCausas() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
