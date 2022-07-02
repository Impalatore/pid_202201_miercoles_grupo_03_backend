package com.example.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Causas")
public class Causas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codcausas")
	private int codcausas;
	
	@Basic(optional = false)
	@Column(name = "descripcion")
	private String descripcion;

	public int getCodcausas() {
		return codcausas;
	}

	public void setCodcausas(int codcausas) {
		this.codcausas = codcausas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
