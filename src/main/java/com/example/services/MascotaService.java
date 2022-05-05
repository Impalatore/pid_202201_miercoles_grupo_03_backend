package com.example.services;

import java.util.List;

import com.example.entity.Mascota;

public interface MascotaService {

	public abstract Mascota inserta(Mascota obj);
	
	public abstract List<Mascota> listaMascota();
}
