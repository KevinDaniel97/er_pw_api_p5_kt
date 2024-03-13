package com.example.er_pw_api_p5_kt.service;

import java.util.List;

import com.example.er_pw_api_p5_kt.service.to.ProductoLigero;
import com.example.er_pw_api_p5_kt.service.to.ProductoTo;

public interface IProductoService {

    public boolean insertar(ProductoTo producto);
	public ProductoTo buscarPorCodigoBarras(String codigoBarras);
	public boolean eliminarPorCodigoBarras(String codigoBarras);
	public List<ProductoLigero> consultarTodos();
    public void actualizar(ProductoTo producto);
    
}
