package com.empresa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.empresa.model.Producto;
import com.empresa.model.dto.DtoProducto;
import com.empresa.repository.ProductoRepository;
import com.empresa.service.ProductoService;

@Service("ProductoServiceImpl")
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	@Qualifier("ProductoRepository")
	private ProductoRepository pr; 
	
	@Override
	@Transactional(rollbackOn = java.lang.Exception.class)
	public Producto addProducto(DtoProducto dtoProducto) {
		
		Producto producto = new Producto();
		
		producto.setDescripcion(dtoProducto.getDescripcion());
		producto.setPrecio(dtoProducto.getPrecio());
		
		pr.save(producto);
		
		return null;
	}

	@Override
	public List<Producto> listProducto() {
		
		return pr.findAll();
	
	}

}
