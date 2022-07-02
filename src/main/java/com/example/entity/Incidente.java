package com.example.entity;

import java.sql.Time;
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
@Table(name = "Incidente")
public class Incidente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codincidente")
	private int codincidente;
	
	@Basic(optional = false)
	@Column(name = "hora")
	private Time hora;
	
	@Basic(optional = false)
	@Column(name = "descripcion")
	private String descripcion;
	
	@Basic(optional = false)
	@Column(name = "estado")
	private int estado;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="America/Lima")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Basic(optional = false)
	@Column(name = "fechaAtencion")
	private Date fechaAtencion;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario idUsuario;

	@ManyToOne
	@JoinColumn(name = "codedificio")
	private Edificio codedificio;
	
	@ManyToOne
	@JoinColumn(name = "coddepartamento")
	private Departamento coddepartamento;
	
	@ManyToOne
	@JoinColumn(name = "codcausas")
	private Causas codcausas;

	public int getCodincidente() {
		return codincidente;
	}

	public void setCodincidente(int codincidente) {
		this.codincidente = codincidente;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Edificio getCodedificio() {
		return codedificio;
	}

	public void setCodedificio(Edificio codedificio) {
		this.codedificio = codedificio;
	}

	public Departamento getCoddepartamento() {
		return coddepartamento;
	}

	public void setCoddepartamento(Departamento coddepartamento) {
		this.coddepartamento = coddepartamento;
	}

	public Causas getCodcausas() {
		return codcausas;
	}

	public void setCodcausas(Causas codcausas) {
		this.codcausas = codcausas;
	}

	

}
