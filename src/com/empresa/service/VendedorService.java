package com.empresa.service;

import java.util.List;

import com.empresa.model.Vendedor;
import com.empresa.model.dto.DtoVendedor;

public interface VendedorService {

	public Vendedor addVendedor(DtoVendedor vendedor);
	
	public List<Vendedor> listVendedores();

}
