package org.example.model;

import lombok.*;

@Builder
@Data
@ToString
public class DetallePedido {
    private Long id;
    private Integer cantidad;
    private Double subTotal;
    private Articulo articulo;
}
