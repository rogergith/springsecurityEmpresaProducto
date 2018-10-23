package com.test.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.model.Vendedor;

@Repository("VendedorRepository")
public interface VendedorRepository extends JpaRepository<Vendedor, Serializable> {

	
	
}
