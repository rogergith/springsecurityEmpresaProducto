package com.test.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.test.model.Producto;
import com.test.model.dto.DtoProducto;
import com.test.repository.ProductoRepository;
import com.test.service.ProductoService;

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
