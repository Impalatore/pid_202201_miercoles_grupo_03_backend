package com.example.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Mascota")
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codmascota")
	private int codmascota;
	
	@Basic(optional = false)
	@Column(name = "nombremascota")
	private String nombremascota;
	
	@Basic(optional = false)
	@Column(name = "edad")
	private int edad;
	
	@Basic(optional = false)
	@Column(name = "raza")
	private String raza;
	
	@ManyToOne
	@JoinColumn(name = "codpropietario")
	private Propietario codpropietario;
	
	@ManyToOne
	@JoinColumn(name = "coddepartamento")
	private Departamento coddepartamento;
	

	public int getCodmascota() {
		return codmascota;
	}

	public void setCodmascota(int codmascota) {
		this.codmascota = codmascota;
	}

	public String getNombremascota() {
		return nombremascota;
	}

	public void setNombremascota(String nombremascota) {
		this.nombremascota = nombremascota;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Propietario getCodpropietario() {
		return codpropietario;
	}

	public void setCodpropietario(Propietario codpropietario) {
		this.codpropietario = codpropietario;
	}

	public Departamento getCoddepartamento() {
		return coddepartamento;
	}

	public void setCoddepartamento(Departamento coddepartamento) {
		this.coddepartamento = coddepartamento;
	}
	
	
	
}
