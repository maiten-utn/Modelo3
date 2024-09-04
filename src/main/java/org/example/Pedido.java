package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido {
    private Long id;
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;
    private Set<DetallePedido> detallePedido;

    public void calcularTotales(){
        this.total = 0.0;
        this.totalCosto = 0.0;
        for (DetallePedido detallePedido : detallePedido) {
            total += detallePedido.getSubTotal();
            totalCosto += detallePedido.getArticulo().getPrecioCompra() * detallePedido.getCantidad();
        }
    }
}
