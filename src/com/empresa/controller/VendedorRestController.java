package com.empresa.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.model.Vendedor;
import com.empresa.model.dto.DtoVendedor;
import com.empresa.service.VendedorService;
import com.empresa.service.interceptor.Interceptor;

@RestController
public class VendedorRestController {

	private Logger LOG = Logger.getLogger(Interceptor.class);
	
	@Autowired
	@Qualifier("VendedorServiceImpl")
	private VendedorService vs;
	
	@GetMapping(value = "/vendedor", produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<Vendedor>> listVendedor(){
		
		HttpStatus status = HttpStatus.OK;
		
		return new ResponseEntity<List<Vendedor>>(vs.listVendedores(), status);
	
	}
	
	@PostMapping(value = "/vendedor", consumes="application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public ResponseEntity<Vendedor> addVendedor(@RequestBody DtoVendedor vendedor){
		
		HttpStatus status = HttpStatus.OK;
	
		vs.addVendedor(vendedor);
	
		return null; //new ResponseEntity<>(status);
	
	}
	
	
	
	
}
