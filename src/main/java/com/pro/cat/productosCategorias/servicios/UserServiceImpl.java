package com.pro.cat.productosCategorias.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.cat.productosCategorias.persistencia.entidades.User;
import com.pro.cat.productosCategorias.persistencia.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public Iterable<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public void bajaUsuario(Long id) {
		userRepo.deleteById(id);		
	}
}
