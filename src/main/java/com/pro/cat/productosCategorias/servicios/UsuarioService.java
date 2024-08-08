package com.pro.cat.productosCategorias.servicios;

import com.pro.cat.productosCategorias.persistencia.entidades.Categoria;
import com.pro.cat.productosCategorias.persistencia.entidades.Producto;

public interface UsuarioService {
	
	Iterable<Producto> obtenerProductos();
	Iterable<Categoria> obtenerCategorias();
	
	Iterable<Producto> obtenerProductos(Long idCategoria);
	
	Producto obtenerProductoPorId(Long id);
}
