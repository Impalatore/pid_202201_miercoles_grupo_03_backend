
package com.example.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Departamento")
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "coddepartamento")
	private int coddepartamento;
	
	@Basic(optional = false)
	@Column(name = "numdepartamento", length = 3)
	private String numdepartamento;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="America/Lima")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Basic(optional = false)
	@Column(name = "fechaentrega")
	private Date fechaentrega;
	
	@Basic(optional = false)
	@Column(name = "precio")
	private Double precio;
	
	@Basic(optional = false)
	@Column(name = "nropiso")
	private int nropiso;
	
	
	@ManyToOne
	@JoinColumn(name = "codedificio")
	private Edificio codedificio;

	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario idUsuario;


	public int getCoddepartamento() {
		return coddepartamento;
	}


	public void setCoddepartamento(int coddepartamento) {
		this.coddepartamento = coddepartamento;
	}


	public String getNumdepartamento() {
		return numdepartamento;
	}


	public void setNumdepartamento(String numdepartamento) {
		this.numdepartamento = numdepartamento;
	}


	public Date getFechaentrega() {
		return fechaentrega;
	}


	public void setFechaentrega(Date fechaentrega) {
		this.fechaentrega = fechaentrega;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public int getNropiso() {
		return nropiso;
	}


	public void setNropiso(int nropiso) {
		this.nropiso = nropiso;
	}


	public Edificio getCodedificio() {
		return codedificio;
	}


	public void setCodedificio(Edificio codedificio) {
		this.codedificio = codedificio;
	}


	public Usuario getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}


	
	

	
}
