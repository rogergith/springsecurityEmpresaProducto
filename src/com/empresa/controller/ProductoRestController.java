package com.empresa.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.model.Producto;
import com.empresa.model.Vendedor;
import com.empresa.model.dto.DtoProducto;
import com.empresa.model.dto.DtoVendedor;
import com.empresa.service.ProductoService;
import com.empresa.service.interceptor.Interceptor;

@RestController
public class ProductoRestController{

	private Logger LOG = Logger.getLogger(ProductoRestController.class);
	
	@Autowired
	@Qualifier("ProductoServiceImpl")
	private ProductoService ps;

	@GetMapping(value = "/producto", produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<Producto>> lisProducto(){
		
		HttpStatus status = HttpStatus.OK;
		
		return new ResponseEntity<List<Producto>>(ps.listProducto(), status);
	
	}
	
	@PostMapping(value = "/producto", consumes="application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public ResponseEntity<Producto> addProducto(@RequestBody DtoProducto dtoProducto){
		
		LOG.info(dtoProducto);
		
		HttpStatus status = HttpStatus.OK;
	
		ps.addProducto(dtoProducto);
	
		return new ResponseEntity<>(status);
	
	}
	
}
