package org.example;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();
}
