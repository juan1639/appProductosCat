package com.pro.cat.productosCategorias.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.cat.productosCategorias.persistencia.entidades.Producto;
import com.pro.cat.productosCategorias.persistencia.repos.ProductoRepository;

@Service
public class AdminServiceImpl extends UsuarioServiceImpl implements AdminService {
	
	@Autowired
	ProductoRepository productoRepo;

	@Override
	public Producto altaProducto(Producto producto) {
		producto.setId(null);
		return productoRepo.save(producto);
	}

	@Override
	public Producto editarProducto(Producto producto) {
		
		if (producto.getId() == null) {
			throw new AdminServiceException("No se puede editar un producto que no tiene id");
		}
		
		return productoRepo.save(producto);
	}
	
	@Override
	public void bajaProducto(Long id) {
		
		productoRepo.deleteById(id);
	}
}
