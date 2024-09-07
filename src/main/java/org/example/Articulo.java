package org.example;

import lombok.*;

@Data
@Builder
@ToString
public class Articulo {
    private Long id;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Integer tiempoEstimadoMinutos;
    private UnidadMedida unidadMedida;
    private Imagen imagen;
}

