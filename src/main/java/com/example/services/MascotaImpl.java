package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Mascota;
import com.example.repository.MascotaRepository;

@Service
public class MascotaImpl implements MascotaService{
	
	@Autowired
	MascotaRepository repositoryM;

	@Override
	public Mascota inserta(Mascota obj) {
		// TODO Auto-generated method stub
		return repositoryM.save(obj);
	}

	@Override
	public List<Mascota> listaMascota() {
		// TODO Auto-generated method stub
		return repositoryM.findAll();
	}
	
	@Override
    public List<Mascota> ListaMascotas() {
        // TODO Auto-generated method stub
        return repositoryM.ListaMascotas();
    }

}
