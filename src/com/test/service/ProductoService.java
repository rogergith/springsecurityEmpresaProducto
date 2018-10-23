package com.test.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.test.model.Producto;
import com.test.model.Vendedor;
import com.test.model.dto.DtoProducto;
import com.test.model.dto.DtoVendedor;

public interface ProductoService {

	@PreAuthorize("hasAnyRole('ADMIN')")
	public Producto addProducto(DtoProducto dtoProducto);
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public List<Producto> listProducto();

	
}
