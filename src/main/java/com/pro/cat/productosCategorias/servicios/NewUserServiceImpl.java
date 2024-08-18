package com.pro.cat.productosCategorias.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.cat.productosCategorias.persistencia.entidades.User;
import com.pro.cat.productosCategorias.persistencia.repos.UserRepository;

@Service
public class NewUserServiceImpl implements NewUserService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public User registroNewUser(User user) {
		return userRepo.save(user);
	}
}
