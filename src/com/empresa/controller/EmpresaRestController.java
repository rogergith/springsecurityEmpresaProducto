package com.empresa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.model.Empresa;
import com.empresa.service.EmpresaService;

@RestController
public class EmpresaRestController {

	@Autowired
	@Qualifier("EmpresaServiceImpl")
	private EmpresaService es;
	
	
	@PostMapping(value="/empresa")
	public ResponseEntity<List<Empresa>> getEmpresa(){
		
		es.addEmpresa(new Empresa("FERRETERIA 201"));
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value="/empresa")
	public ResponseEntity<List<Empresa>> addEmpresa(){
		
		List<Empresa> lista = new ArrayList<Empresa>();
		
		return new ResponseEntity<List<Empresa>>(lista, HttpStatus.OK);
	}
	
}
