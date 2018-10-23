package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.test.model.Empresa;
import com.test.repository.EmpresaRepository;
import com.test.service.EmpresaService;

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
