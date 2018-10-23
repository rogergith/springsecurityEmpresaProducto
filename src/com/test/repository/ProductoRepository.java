package com.test.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.model.Producto;

@Repository("ProductoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Serializable>{

}
