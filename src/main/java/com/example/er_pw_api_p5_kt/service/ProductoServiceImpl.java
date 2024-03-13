package com.example.er_pw_api_p5_kt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.er_pw_api_p5_kt.repository.IProductoRepository;
import com.example.er_pw_api_p5_kt.repository.modelo.Producto;
import com.example.er_pw_api_p5_kt.service.to.ProductoLigero;
import com.example.er_pw_api_p5_kt.service.to.ProductoTo;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private IProductoRepository iProductoRespotory;

    @Override
    public boolean insertar(ProductoTo producto) {

        boolean insertado = true;
		ProductoTo p;

		try {
			p = this.buscarPorCodigoBarras(producto.getCodigoBarras());
		} catch (Exception e) {
			p = null;
		}
		
		if(p==null){
			this.iProductoRespotory.insertar(this.convertirTO(producto));
		} else {
			insertado = false;
		}

		return insertado;
    }

    @Override
    public ProductoTo buscarPorCodigoBarras(String codigoBarras) {
        // TODO Auto-generated method stub
        return this.convertir(this.iProductoRespotory.buscarPorCodigo(codigoBarras));
    }

    @Override
    public boolean eliminarPorCodigoBarras(String codigoBarras) {
        // TODO Auto-generated method stub

		boolean eliminado = true;
		try {
			this.iProductoRespotory.eliminarPorCodigo(codigoBarras);
			
		} catch (Exception e) {
			eliminado = false;
		}
		return eliminado;
	}

    @Override
    public List<ProductoLigero> consultarTodos() {
        List<Producto> lista = this.iProductoRespotory.consultarTodos();
		
		return lista.stream().map(p -> this.convertirLigero(p)).toList();
    }

    @Override
    public void actualizar(ProductoTo producto) {

            this.iProductoRespotory.actualizar(this.convertirTO(producto));

    }



    private ProductoTo convertir(Producto producto) {
		ProductoTo p = new ProductoTo();
		p.setCodigoBarras(producto.getCodigoBarras());
		p.setFechaCaducidad(producto.getFechaCaducidad());
		p.setId(producto.getId());
		p.setNombre(producto.getNombre());
        p.setStock(producto.getStock());

		return p;
	}
	
	private Producto convertirTO(ProductoTo producto) {
		Producto p = new Producto();
		p.setCodigoBarras(producto.getCodigoBarras());
		p.setFechaCaducidad(producto.getFechaCaducidad());
		p.setId(producto.getId());
		p.setNombre(producto.getNombre());
        p.setStock(producto.getStock());
		return p;
	}

    private ProductoLigero convertirLigero(Producto producto) {
		ProductoLigero p = new ProductoLigero();
		p.setCodigoBarras(producto.getCodigoBarras());
		p.setNombre(producto.getNombre());
   
		return p;
	}


    
}
