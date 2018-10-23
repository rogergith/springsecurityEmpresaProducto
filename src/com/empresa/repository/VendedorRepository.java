package com.empresa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.model.Vendedor;

@Repository("VendedorRepository")
public interface VendedorRepository extends JpaRepository<Vendedor, Serializable> {

	
	
}
