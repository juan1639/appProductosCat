package com.pro.cat.productosCategorias.servicios;

import com.pro.cat.productosCategorias.persistencia.entidades.User;

public interface UserService {
	
	Iterable<User> findAll();
	void bajaUsuario(Long id);
}
