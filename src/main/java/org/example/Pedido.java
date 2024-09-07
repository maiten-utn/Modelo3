package org.example;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

@Data
@Builder
public class Pedido {
    private Long id;
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private EstadoPedido estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;
    private HashSet<DetallePedido> detalles;
    
    public enum EstadoPedido {
        PENDIENTE, EN_PROCESO, FINALIZADO, CANCELADO
    }
    
    public enum TipoEnvio {
        DOMICILIO, RETIRO_EN_TIENDA
    }
    
    public enum FormaPago {
        EFECTIVO, TARJETA_CREDITO, TARJETA_DEBITO, TRANSFERENCIA_BANCARIA
    }
}