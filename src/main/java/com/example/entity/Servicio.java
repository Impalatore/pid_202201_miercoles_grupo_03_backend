package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="servicio")
@Getter
@Setter
public class Servicio {

	@Id
	private int codservicio;
	private String tiposervicio;
}
