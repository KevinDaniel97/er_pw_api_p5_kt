package com.example.er_pw_api_p5_kt.controller;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.er_pw_api_p5_kt.service.IProductoService;
import com.example.er_pw_api_p5_kt.service.to.ProductoLigero;
import com.example.er_pw_api_p5_kt.service.to.ProductoTo;

@RestController
@RequestMapping("/productos")
@CrossOrigin
public class ProductoControllerRestful {

    @Autowired
    private IProductoService iProductoService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> guardar(@RequestBody ProductoTo p) {
		boolean ingresado = this.iProductoService.insertar(p);
		if(ingresado)  {
			return ResponseEntity.status(HttpStatus.OK).body("Se ha guardado correctamente "+p.getCodigoBarras());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha podido guardar: "+p.getCodigoBarras());
		}
	}

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductoLigero>> consultarTodos(){
		List<ProductoLigero> lista =this.iProductoService.consultarTodos();
		for (ProductoLigero productoLigero : lista) {
			Link myLink = linkTo(methodOn(ProductoControllerRestful.class).consultarPorCodigoBarras(productoLigero.getCodigoBarras()))
					.withSelfRel();
                    productoLigero.add(myLink);
		}
		return new ResponseEntity<>(lista,null,200);
	}


    @DeleteMapping(path="/{codigoBarras}")
	public ResponseEntity<String> eliminarPorCodigoBarras(@PathVariable String codigoBarras) {
		boolean eliminado = this.iProductoService.eliminarPorCodigoBarras(codigoBarras);
		if(eliminado)  {
			return ResponseEntity.status(HttpStatus.OK).body("Se ha eliminado el registro con: "+codigoBarras);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha podido eliminar: "+codigoBarras);
		}
	}



	@GetMapping(path="/{codigoBarras}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoTo> consultarPorCodigoBarras(@PathVariable String codigoBarras) {
		ProductoTo productoTo = this.iProductoService.buscarPorCodigoBarras(codigoBarras);
		
		return new ResponseEntity<>(productoTo,null,200);
	}

    
    @PutMapping(path="/{codigoBarras}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizar (@RequestBody ProductoTo producto){
        this.iProductoService.actualizar(producto);
    }
    





}
