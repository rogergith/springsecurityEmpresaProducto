package com.empresa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="producto")
public class Producto {

	//USAR ESTO CON HIBERNATE 5
	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO, 
	    generator="native"
	)
	@Column(name="idproducto")
	@GenericGenerator(
	    name = "native", 
	    strategy = "native"
	)
	private int idproducto;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="precio")
	private String precio;

	public Producto() {}

	public Producto(String descripcion, String precio) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Producto(int idproducto, String descripcion, String precio) {
		super();
		this.idproducto = idproducto;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [idproducto=" + idproducto + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	
	
}
