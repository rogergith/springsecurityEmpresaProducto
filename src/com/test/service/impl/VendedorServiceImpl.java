package com.test.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.test.model.Empresa;
import com.test.model.Vendedor;
import com.test.model.dto.DtoVendedor;
import com.test.repository.EmpresaRepository;
import com.test.repository.VendedorRepository;
import com.test.service.VendedorService;

@Service("VendedorServiceImpl")
public class VendedorServiceImpl implements VendedorService{

	@Autowired
	@Qualifier("VendedorRepository")
	private VendedorRepository vr;
	
	@Autowired
	@Qualifier("EmpresaRepository")
	private EmpresaRepository er;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public Vendedor addVendedor(DtoVendedor dtoVendedor) {
	
		Empresa empresa = er.findById(dtoVendedor.getIdempresa()).get();
			
		Vendedor vendedor = new Vendedor();
			
		vendedor.setIdempresa(empresa);
		vendedor.setNombre(dtoVendedor.getNombre());
		vendedor.setTelefono(dtoVendedor.getTelefono());
		
		vr.save(vendedor);
		
		return null; // 
	
	}

	@Override
	public List<Vendedor> listVendedores() {
	
		return vr.findAll();
	
	}

	
	
}
