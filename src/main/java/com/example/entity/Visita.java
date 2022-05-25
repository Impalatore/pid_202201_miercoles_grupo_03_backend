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
@Table(name = "Visita")
public class Visita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "codvisita")
	private int codvisita;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="America/Lima")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Basic(optional = false)
	@Column(name = "fechavisita")
	private Date fechavisita;
	
	@Basic(optional = false)
	@Column(name = "horavisita")
	private String horavisita;
	
	@Basic(optional = false)
	@Column(name = "horasalida")
	private String horasalida;
	
	@Basic(optional = true)
	@Column(name = "comentario")
	private String comentario;
	
	@Basic(optional = false)
	@Column(name = "estado")
	private int estado;
	
	@ManyToOne
	@JoinColumn(name = "coddepartamento")
	private Departamento coddepartamento;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario idUsuario;
	
	@ManyToOne
	@JoinColumn(name = "codvisitantes")
	private Visitante codvisitantes;

	public int getCodvisita() {
		return codvisita;
	}

	public void setCodvisita(int codvisita) {
		this.codvisita = codvisita;
	}

	public Date getFechavisita() {
		return fechavisita;
	}

	public void setFechavisita(Date fechavisita) {
		this.fechavisita = fechavisita;
	}

	public String getHoravisita() {
		return horavisita;
	}

	public void setHoravisita(String horavisita) {
		this.horavisita = horavisita;
	}

	public String getHorasalida() {
		return horasalida;
	}

	public void setHorasalida(String horasalida) {
		this.horasalida = horasalida;
	}

	
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Departamento getCoddepartamento() {
		return coddepartamento;
	}

	public void setCoddepartamento(Departamento coddepartamento) {
		this.coddepartamento = coddepartamento;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Visitante getCodvisitantes() {
		return codvisitantes;
	}

	public void setCodvisitantes(Visitante codvisitantes) {
		this.codvisitantes = codvisitantes;
	}
	
	
}
