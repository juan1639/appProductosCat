package com.pro.cat.productosCategorias.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pro.cat.productosCategorias.persistencia.entidades.Producto;
import com.pro.cat.productosCategorias.servicios.AdminService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminControlador {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/productos")
	public String listarProductos(Model modelo) {
		
		modelo.addAttribute("productos", adminService.obtenerProductos());
		return "admin/productos";
	}
	
	@GetMapping({"/producto", "/producto/{id}"})
	public String formularioProducto(@PathVariable(required = false) Long id, Model modelo) {
		
		modelo.addAttribute("categorias", adminService.obtenerCategorias());
		
		if (id == null) {
			modelo.addAttribute("producto", new Producto());
			
		} else {
			modelo.addAttribute("producto", adminService.obtenerProductoPorId(id));
		}
		
		return "admin/producto";
	}
	
	@PostMapping("/producto")
	public String postProducto(@Valid Producto producto, BindingResult bindingResult, Model modelo) {
		
		if (bindingResult.hasErrors()) {
			
			modelo.addAttribute("categorias", adminService.obtenerCategorias());
			return "admin/producto";
		}
		
		if (producto.getId() == null) {
			
			adminService.altaProducto(producto);
			
		} else {
			adminService.editarProducto(producto);
		}
		
		return "redirect:/admin/productos";
	}
	
	@GetMapping("/producto/borrar/{id}")
	public String borrarProducto(@PathVariable Long id) {
		
		adminService.bajaProducto(id);
		return "redirect:/admin/productos";
	}
}
