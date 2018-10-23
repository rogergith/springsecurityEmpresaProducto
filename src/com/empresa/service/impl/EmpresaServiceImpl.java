package com.empresa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.empresa.model.Empresa;
import com.empresa.repository.EmpresaRepository;
import com.empresa.service.EmpresaService;

@Service("EmpresaServiceImpl")
public class EmpresaServiceImpl implements EmpresaService{

	@Autowired
	@Qualifier("EmpresaRepository")
	private EmpresaRepository er;
	
	@Override
	public Empresa addEmpresa(Empresa empresa) {
		
		return er.save(empresa);
	
	}

}
