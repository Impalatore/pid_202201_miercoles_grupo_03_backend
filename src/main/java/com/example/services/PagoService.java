package com.example.services;

import java.util.List;

import com.example.entity.Pago;

public interface PagoService {

	public abstract Pago insertaActualizaPago(Pago obj);
	
	public abstract List<Pago> listaxtodos();
}
