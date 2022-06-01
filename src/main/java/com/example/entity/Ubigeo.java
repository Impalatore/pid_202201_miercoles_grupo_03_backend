package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Ubigeo")
public class Ubigeo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUbigeo")
	private int codubigeo;
	@Column(name = "departamento")
	private String departamento;
	@Column(name = "provincia")
	private String provincia;
	@Column(name = "distrito")
	private String distrito;

	public int getCodubigeo() {
		return codubigeo;
	}

	public void setCodubigeo(int codubigeo) {
		this.codubigeo = codubigeo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

}
