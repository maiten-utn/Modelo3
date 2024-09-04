package org.model;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DetallePedido {
    private Long id;
    private int cantidad;
    private double subTotal;
    @ToString.Exclude
    private Articulo articulo;


}
