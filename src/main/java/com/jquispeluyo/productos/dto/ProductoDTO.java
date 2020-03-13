package com.jquispeluyo.productos.dto;

import lombok.Data;

@Data
public class ProductoDTO {

    private String _id;
    private String descripcion;
    private Double precio;
    private Integer cantidad;

}
