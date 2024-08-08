package com.pro.cat.productosCategorias.persistencia.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.cat.productosCategorias.persistencia.entidades.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	Iterable<Producto> findByCategoriaId(Long idCategoria);
}
