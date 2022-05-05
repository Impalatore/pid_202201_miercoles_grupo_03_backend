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
@Table(name = "Visitante")
public class Visitante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codvisitantes")
	private int codvisitantes;
	
	@Basic(optional = false)
	@Column(name = "dni", length = 8)
	private String dni;
	
	@Basic(optional = false)
	@Column(name = "nombrevisitante")
	private String nombrevisitante;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario idUsuario;
	
	@ManyToOne
	@JoinColumn(name = "codpropietario")
	private Propietario codpropietario;

	public int getCodvisitantes() {
		return codvisitantes;
	}

	public void setCodvisitantes(int codvisitantes) {
		this.codvisitantes = codvisitantes;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombrevisitante() {
		return nombrevisitante;
	}

	public void setNombrevisitante(String nombrevisitante) {
		this.nombrevisitante = nombrevisitante;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Propietario getCodpropietario() {
		return codpropietario;
	}

	public void setCodpropietario(Propietario codpropietario) {
		this.codpropietario = codpropietario;
	}

	
	

}
