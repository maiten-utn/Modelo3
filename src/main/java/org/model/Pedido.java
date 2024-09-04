package org.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Pedido {
    private Long id;
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;
    @Builder.Default
    @ToString.Exclude
    private Set<DetallePedido> detalles = new HashSet<>();

    public void agregarDetallePedido(DetallePedido detallePedido){
        this.detalles.add(detallePedido);
    }
    public void removerDetallePedido(DetallePedido detallePedido){
        this.detalles.remove(detallePedido);
    }
    public void calcularTotal(){
        Double totalDetalles = 0D;
        Double totalCostoDetalles = 0D;
        for (DetallePedido d : detalles){
            totalDetalles += d.getSubTotal()*d.getCantidad();
            totalCostoDetalles += d.getArticulo().getPrecioCompra()*d.getCantidad();
        }
        this.total = totalDetalles;
        this.totalCosto = totalCostoDetalles;
    }
}
