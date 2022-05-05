package com.example.entity;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name = "Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idUsuario")
	private int idUsuario; 
	
	@Basic(optional = false)
	@Column(name = "dni")
	private String dni;
	
	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;
	
	@Basic(optional = false)
	@Column(name = "primerapellido")
	private String primerapellido;
	
	@Basic(optional = false)
	@Column(name = "segundoapellido")
	private String segundoapellido;
	
	@Basic(optional = false)
	@Column(name = "telefono")
	private String telefono;
	
	@Basic(optional = false)
	@Column(name = "celular")
	private String celular;
	
	@Basic(optional = false)
	@Column(name = "direccion")
	private String direccion;
	
	@Basic(optional = false)
	@Column(name = "correo")
	private String correo;
	
	@Basic(optional = false)
	@Column(name = "password")
	private String password;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="America/Lima")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Basic(optional = false)
	@Column(name = "fechareg")
	private Date fechareg;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idubigeo")
	@Basic(optional = false)
	private Ubigeo idUbigeo;
	
	@Basic(optional = false)
	@Column(name = "login")
	private String login;
	
	@Basic(optional = false)
	@Column(name = "estado")
	private boolean estado;
  
	@Transactional
	public String getNombreCompleto() {
		return nombre.concat(" ").concat(primerapellido+" "+segundoapellido);
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerapellido() {
		return primerapellido;
	}

	public void setPrimerapellido(String primerapellido) {
		this.primerapellido = primerapellido;
	}

	public String getSegundoapellido() {
		return segundoapellido;
	}

	public void setSegundoapellido(String segundoapellido) {
		this.segundoapellido = segundoapellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechareg() {
		return fechareg;
	}

	public void setFechareg(Date fechareg) {
		this.fechareg = fechareg;
	}

	public Ubigeo getIdUbigeo() {
		return idUbigeo;
	}

	public void setIdUbigeo(Ubigeo idUbigeo) {
		this.idUbigeo = idUbigeo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	
	
}
