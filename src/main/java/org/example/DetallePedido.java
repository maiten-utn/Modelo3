package org.example;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedido {
    private Long id;
    private Articulo articulo;
    private Integer cantidad;
    private Double subTotal;

    public void calcularSubTotal() {
        subTotal = articulo.getPrecioVenta() * cantidad;
    }
}
