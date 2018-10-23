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
@Table(name="producto_vendedor")
public class ProductoVendedor {

	//USAR ESTO CON HIBERNATE 5
	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO, 
	    generator="native"
	)
	@Column(name="id")
	@GenericGenerator(
	    name = "native", 
	    strategy = "native"
	)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idproducto", referencedColumnName="idproducto")
	private Producto idproducto;

	@ManyToOne
	@JoinColumn(name="idvendedor", referencedColumnName="idvendedor")
	private Vendedor idvendedor;
		
	public ProductoVendedor() {}

	public ProductoVendedor(Producto idproducto, Vendedor idvendedor) {
		super();
		this.idproducto = idproducto;
		this.idvendedor = idvendedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Producto idproducto) {
		this.idproducto = idproducto;
	}

	public Vendedor getIdvendedor() {
		return idvendedor;
	}

	public void setIdvendedor(Vendedor idvendedor) {
		this.idvendedor = idvendedor;
	}

	@Override
	public String toString() {
		return "ProductoVendedor [idproducto=" + idproducto + ", idvendedor=" + idvendedor + "]";
	}
	
}
