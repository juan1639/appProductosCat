package com.pro.cat.productosCategorias.servicios;

import com.pro.cat.productosCategorias.persistencia.entidades.Producto;

public interface AdminService extends UsuarioService {
	
	Producto altaProducto(Producto producto);
	Producto editarProducto(Producto producto);
	void bajaProducto(Long id);
}
