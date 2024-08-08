package com.pro.cat.productosCategorias.persistencia.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pro.cat.productosCategorias.persistencia.entidades.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	@Query("select c from Categoria c left join fetch c.productos where c.id = :id")
	Categoria obtenerPorIdConProductos(Long id);
}
