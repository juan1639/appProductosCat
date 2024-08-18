package com.pro.cat.productosCategorias.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pro.cat.productosCategorias.dto.NewUserDTO;
import com.pro.cat.productosCategorias.persistencia.entidades.User;
import com.pro.cat.productosCategorias.servicios.NewUserService;
import com.pro.cat.productosCategorias.servicios.UsuarioService;

@Controller
public class UsuarioControlador {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	NewUserService newUserService;

	// *********** USER DTO *************
	@ModelAttribute("newuser")
	public NewUserDTO getNewUser() {
		return new NewUserDTO();
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping({ "/", "/index" })
	public String index(Model modelo) {

		modelo.addAttribute("categorias", usuarioService.obtenerCategorias());
		modelo.addAttribute("productos", usuarioService.obtenerProductos());

		return "index";
	}

	@GetMapping("/categoria/{idCategoria}")
	public String indexCategoria(@PathVariable Long idCategoria, Model modelo) {

		modelo.addAttribute("categorias", usuarioService.obtenerCategorias());
		modelo.addAttribute("productos", usuarioService.obtenerProductos(idCategoria));

		return "index";
	}

	@GetMapping("/login")
	public String formLogin() {
		return "login";
	}

	@GetMapping("/registro")
	public String registrarse() {
		return "registro";
	}

	@PostMapping("/registro")
	public String postRegistrarse(@ModelAttribute("newuser") NewUserDTO newuser, Model modelo) {

		User user = new User(null, newuser.getUsername(), passwordEncoder.encode(newuser.getPassword()),
				newuser.getRole());

		newUserService.registroNewUser(user);
		modelo.addAttribute("nuevousuario", user);
		return "usuarioregistrado";
	}
}
