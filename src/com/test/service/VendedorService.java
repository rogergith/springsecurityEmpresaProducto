package com.test.service;

import java.util.List;

import com.test.model.Vendedor;
import com.test.model.dto.DtoVendedor;

public interface VendedorService {

	public Vendedor addVendedor(DtoVendedor vendedor);
	
	public List<Vendedor> listVendedores();

}
