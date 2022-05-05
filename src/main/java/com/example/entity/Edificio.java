package com.example.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Edificio")
public class Edificio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codedificio")
	private int codedificio;
	
	@Basic(optional = false)
	@Column(name = "nomedificio")
	private String nomedificio;
	
	@Basic(optional = false)
	@Column(name = "direccion")
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario idUsuario;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idubigeo")
	@Basic(optional = false)
	private Ubigeo idUbigeo;

	public int getCodedificio() {
		return codedificio;
	}

	public void setCodedificio(int codedificio) {
		this.codedificio = codedificio;
	}

	public String getNomedificio() {
		return nomedificio;
	}

	public void setNomedificio(String nomedificio) {
		this.nomedificio = nomedificio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Ubigeo getIdUbigeo() {
		return idUbigeo;
	}

	public void setIdUbigeo(Ubigeo idUbigeo) {
		this.idUbigeo = idUbigeo;
	}

	
	
}
