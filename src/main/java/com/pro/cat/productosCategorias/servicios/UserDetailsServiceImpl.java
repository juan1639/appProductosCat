package com.pro.cat.productosCategorias.servicios;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pro.cat.productosCategorias.persistencia.entidades.SecurityUser;
import com.pro.cat.productosCategorias.persistencia.entidades.User;
import com.pro.cat.productosCategorias.persistencia.repos.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		return new SecurityUser(user);
	}
}
