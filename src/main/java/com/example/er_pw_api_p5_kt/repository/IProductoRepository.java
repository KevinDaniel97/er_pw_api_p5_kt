package com.example.er_pw_api_p5_kt.repository;

import java.util.List;

import com.example.er_pw_api_p5_kt.repository.modelo.Producto;

public interface IProductoRepository {
    
    public void insertar(Producto producto);
	public Producto buscarPorCodigo(String codigoBarras);
	public void eliminarPorCodigo(String codigoBarras);
	public void actualizar(Producto producto);
	public List<Producto> consultarTodos();
}
