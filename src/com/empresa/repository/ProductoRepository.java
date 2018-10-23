package com.empresa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.model.Producto;

@Repository("ProductoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Serializable>{

}
