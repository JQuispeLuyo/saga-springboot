package com.jquispeluyo.productos.controllers;

import com.jquispeluyo.productos.models.Producto;
import com.jquispeluyo.productos.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping()
    public List<Producto> findAll (){
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Producto findById (@PathVariable("id") String id){
        return productoService.findById(id);
    }

    @GetMapping("/update-cantidad")
    public Producto updateCantidad (@RequestParam("id") String id, @RequestParam("cantidad") Integer cantidad){
        return productoService.updateCantidad(id, cantidad);
    }

    @GetMapping("/update-cantidad-fallback")
    public Producto updateCantidadFallback (@RequestParam("id") String id, @RequestParam("cantidad") Integer cantidad){
        return productoService.updateCantidadFallback(id, cantidad);
    }
}
