package com.pro.cat.productosCategorias.persistencia.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pro.cat.productosCategorias.persistencia.entidades.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	Iterable<User> findAll();
}
