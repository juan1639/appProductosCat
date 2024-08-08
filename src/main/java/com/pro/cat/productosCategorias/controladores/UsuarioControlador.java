package com.pro.cat.productosCategorias.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pro.cat.productosCategorias.servicios.UsuarioService;

@Controller
public class UsuarioControlador {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping({"/", "/index"})
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
}
