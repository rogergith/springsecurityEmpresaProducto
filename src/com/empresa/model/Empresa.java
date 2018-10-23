package com.empresa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="empresa")
public class Empresa {
	
	/*
	@Id
	@Column(name="idempresa")
	@GeneratedValue(strategy= GenerationType.AUTO)
	*/
	//USAR ESTO CON HIBERNATE 5
	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO, 
	    generator="native"
	)
	@Column(name="idempresa")
	@GenericGenerator(
	    name = "native", 
	    strategy = "native"
	)
	private int idempresa;
	
	@Column(name="nombre")
	private String nombre;
	
	public Empresa() {}
	
	public Empresa(int idempresa, String nombre) {
		super();
		this.idempresa = idempresa;
		this.nombre = nombre;
	}

	public Empresa( String nombre) {
		this.nombre = nombre;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empresa [idempresa=" + idempresa + ", nombre=" + nombre + "]";
	}

	
	
}

