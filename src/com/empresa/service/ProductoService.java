package com.empresa.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.empresa.model.Producto;
import com.empresa.model.Vendedor;
import com.empresa.model.dto.DtoProducto;
import com.empresa.model.dto.DtoVendedor;

public interface ProductoService {

	@PreAuthorize("hasAnyRole('ADMIN')")
	public Producto addProducto(DtoProducto dtoProducto);
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public List<Producto> listProducto();

	
}
