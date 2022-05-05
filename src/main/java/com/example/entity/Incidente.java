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
	private String hora;
	
	@Basic(optional = false)
	@Column(name = "descripcion")
	private String descripcion;
	
	@Basic(optional = false)
	@Column(name = "estado")
	private boolean estado;
	
	@Basic(optional = false)
	@Column(name = "fechaAtencion")
	private Date fechaAtencion;
	
	@Basic(optional = false)
	@Column(name = "fechaRegistro")
	private Date fechaRegistro;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario idUsuario;

	public int getCodincidente() {
		return codincidente;
	}

	public void setCodincidente(int codincidente) {
		this.codincidente = codincidente;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Date getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
}