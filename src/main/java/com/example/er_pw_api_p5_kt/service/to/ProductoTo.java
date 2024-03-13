package com.example.er_pw_api_p5_kt.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.springframework.hateoas.RepresentationModel;

public class ProductoTo extends RepresentationModel <ProductoTo> implements Serializable {

	private static final long serialVersionUID = 1L;
    private Integer id;
    private String codigoBarras;
    private String nombre;
    private Integer stock;
    private LocalDateTime fechaCaducidad;

    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
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
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public LocalDateTime getFechaCaducidad() {
        return fechaCaducidad;
    }
    public void setFechaCaducidad(LocalDateTime fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    
}
