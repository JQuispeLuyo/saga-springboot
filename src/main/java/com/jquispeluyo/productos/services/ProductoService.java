package com.jquispeluyo.productos.services;

import com.jquispeluyo.productos.error.ProductoNotFoundException;
import com.jquispeluyo.productos.models.Producto;
import com.jquispeluyo.productos.repositories.ProductoRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductoRepository productoRepository;

    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList() {
        URI uri = URI.create("http://localhost:8090/recommended");
        return this.restTemplate.getForObject(uri, String.class);
    }

    public String reliable() {
        return "Cloud Native Java (O'Reilly)";
    }

    public List<Producto> findAll (){
        return productoRepository.findAll();
    }

    public Producto findById (String id){
        return productoRepository.findById(id)
                .orElseGet(()->{
                    throw new ProductoNotFoundException(id);
                });
    }

    public Producto updateCantidad (String id, Integer cantidad){
        return productoRepository.findById(id)
                .map((x)->{
                    x.setCantidad(x.getCantidad() - cantidad);
                    return productoRepository.save(x);
                })
                .orElseGet(()->{
                    throw new ProductoNotFoundException(id);
                });
    }

    public Producto updateCantidadFallback (String id, Integer cantidad){
        return productoRepository.findById(id)
                .map((x)->{
                    x.setCantidad(x.getCantidad() - cantidad);
                    return productoRepository.save(x);
                })
                .orElseGet(()->{
                    throw new ProductoNotFoundException(id);
                });
    }

}
