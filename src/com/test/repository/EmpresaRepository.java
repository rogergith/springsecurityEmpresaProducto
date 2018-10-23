package com.test.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.model.Empresa;

@Repository("EmpresaRepository")
public interface EmpresaRepository extends JpaRepository<Empresa, Serializable>{

}
