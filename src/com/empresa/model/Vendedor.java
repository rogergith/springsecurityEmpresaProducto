package com.empresa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="vendedor")
public class Vendedor {

	//USAR ESTO CON HIBERNATE 5
	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO, 
	    generator="native"
	)
	@Column(name="idvendedor")
	@GenericGenerator(
	    name = "native", 
	    strategy = "native"
	)
	private int idvendedor;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="telefono")
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name="idempresa", referencedColumnName="idempresa")
	private Empresa idempresa;

	public Vendedor() {}
		
	public Vendedor(String nombre, String telefono, Empresa idempresa) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.idempresa = idempresa;
	}

	public Empresa getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(Empresa idempresa) {
		this.idempresa = idempresa;
	}

	public int getIdvendedor() {
		return idvendedor;
	}

	public void setIdvendedor(int idvendedor) {
		this.idvendedor = idvendedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Vendedor [idvendedor=" + idvendedor + ", nombre=" + nombre + ", telefono=" + telefono + ", idempresa="
				+ idempresa + "]";
	}

	

	

	
	
	
}
