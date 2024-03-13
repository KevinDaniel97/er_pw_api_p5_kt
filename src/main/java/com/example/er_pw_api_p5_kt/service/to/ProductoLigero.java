package com.example.er_pw_api_p5_kt.service.to;

import java.io.Serializable;


import org.springframework.hateoas.RepresentationModel;

public class ProductoLigero extends RepresentationModel <ProductoTo> implements Serializable  {

    private static final long serialVersionUID = 1L;

    private String codigoBarras;
    private String nombre;


    public String getCodigoBarras() {
        return codigoBarras;
    }
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
