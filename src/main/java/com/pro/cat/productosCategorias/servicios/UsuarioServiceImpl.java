package com.pro.cat.productosCategorias.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.pro.cat.productosCategorias.persistencia.entidades.Categoria;
import com.pro.cat.productosCategorias.persistencia.entidades.Producto;
import com.pro.cat.productosCategorias.persistencia.repos.CategoriaRepository;
import com.pro.cat.productosCategorias.persistencia.repos.ProductoRepository;

@Service
@Primary
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	ProductoRepository productoRepo;
	
	@Autowired
	CategoriaRepository categoriaRepo;

	@Override
	public Iterable<Producto> obtenerProductos() {
		return productoRepo.findAll();
	}

	@Override
	public Iterable<Categoria> obtenerCategorias() {
		return categoriaRepo.findAll();
	}

	@Override
	public Iterable<Producto> obtenerProductos(Long idCategoria) {
		return productoRepo.findByCategoriaId(idCategoria);
	}

	@Override
	public Producto obtenerProductoPorId(Long id) {
		return productoRepo.findById(id).orElse(null);
	}
}
