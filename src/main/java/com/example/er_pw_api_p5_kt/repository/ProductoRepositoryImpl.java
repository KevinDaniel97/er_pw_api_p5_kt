package com.example.er_pw_api_p5_kt.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.er_pw_api_p5_kt.repository.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{


    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public Producto buscarPorCodigo(String codigoBarra) {
        // TODO Auto-generated method stub
        TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras= :datoCodigo", Producto.class);
		myQuery.setParameter("datoCodigo", codigoBarra);
		return myQuery.getSingleResult();
    }

    @Override
    public void insertar(Producto producto) {
        // TODO Auto-generated method stub
        this.entityManager.persist(producto);
    }

    @Override
    public void eliminarPorCodigo(String codigoBarra) {
        // TODO Auto-generated method stub
        this.entityManager.remove(this.buscarPorCodigo(codigoBarra));
    }

    @Override
    public List<Producto> consultarTodos() {
        // TODO Auto-generated method stub
        TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p", Producto.class);
		return myQuery.getResultList();

    }


    @Override
    public void actualizar(Producto producto) {
        Producto p = this.buscarPorCodigo(producto.getCodigoBarras());
        p.setNombre(producto.getNombre());
        p.setStock(producto.getStock());
        p.setFechaCaducidad(producto.getFechaCaducidad());
    
        this.entityManager.merge(p);
        
    }
    
}
