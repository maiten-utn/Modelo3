package org.example;

import org.example.model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // CREACION DE CLIENTES
        Cliente cliente1 = crearCliente(1L, "Emiliano", "Caceres", "451634981", "emicaceres@gmail.com", LocalDate.of(1999, 1, 1));
        Cliente cliente2 = crearCliente(2L, "Milagros", "Esquivel", "343894212", "milagros12@gmail.com", LocalDate.of(2004, 2, 9));
        Cliente cliente3 = crearCliente(3L, "Azul", "Morales", "56312823", "azulmor@gmail.com", LocalDate.of(1956, 9, 23));
        
        // CREACION DE UNIDADES DE MEDIDA
        UnidadMedida unidadMedida1 = crearUnidadMedida(1L, "8 Porciones");
        UnidadMedida unidadMedida2 = crearUnidadMedida(2L, "4 Porciones");
        UnidadMedida unidadMedida3 = crearUnidadMedida(3L, "1 Litro");
        
        // CREACION DE IMAGENES
        Imagen[] imagenes = {
                crearImagen(1L, "Pizza grande hawaiana"),
                crearImagen(2L, "Pizza grande napolitana"),
                crearImagen(3L, "Pizza grande muzza"),
                crearImagen(4L, "Pizza chica hawaiana"),
                crearImagen(5L, "Pizza chica napolitana"),
                crearImagen(6L, "Pizza chica muzza"),
                crearImagen(7L, "Cerveza Andes"),
                crearImagen(8L, "Cerveza Quilmes")
        };
        
        // CREACION DE ARTICULOS
        Articulo[] articulos = {
                crearArticulo(1L, "Pizza grande Hawaiana", 110.0, 40.0, 18, 30, 10, unidadMedida1, imagenes[0]),
                crearArticulo(2L, "Pizza chica Hawaiana", 65.0, 25.0, 25, 30, 10, unidadMedida2, imagenes[3]),
                crearArticulo(3L, "Pizza grande Napolitana", 140.0, 55.0, 12, 28, 8, unidadMedida1, imagenes[1]),
                crearArticulo(4L, "Pizza chica Napolitana", 80.0, 30.0, 5, 30, 8, unidadMedida2, imagenes[4]),
                crearArticulo(5L, "Pizza grande Muzza", 145.0, 60.0, 10, 25, 10, unidadMedida1, imagenes[2]),
                crearArticulo(6L, "Pizza chica Muzza", 55.0, 25.0, 8, 20, 5, unidadMedida2, imagenes[5]),
                crearArticulo(7L, "Cerveza Andes", 35.0, 22.0, 40, 60, 5, unidadMedida3, imagenes[6]),
                crearArticulo(8L, "Cerveza Quilmes", 25.0, 15.0, 20, 40, 5, unidadMedida3, imagenes[7])
        };
        
        // Pedidos
        Pedido pedido1 = crearPedido(1L, LocalTime.of(22, 30), Pedido.EstadoPedido.EN_PROCESO, Pedido.TipoEnvio.RETIRO_EN_TIENDA, Pedido.FormaPago.EFECTIVO, LocalDate.of(2024, 9, 1),
                new DetallePedido[]{crearDetallePedido(1L, 1, articulos[4].getPrecioVenta(), articulos[4]), crearDetallePedido(2L, 1,  articulos[4].getPrecioVenta(), articulos[7])}, cliente1);
        
        Pedido pedido2 = crearPedido(2L, LocalTime.of(15, 15), Pedido.EstadoPedido.EN_PROCESO, Pedido.TipoEnvio.DOMICILIO, Pedido.FormaPago.TARJETA_DEBITO, LocalDate.of(2024, 9, 1),
                new DetallePedido[]{crearDetallePedido(3L, 1, articulos[1].getPrecioVenta(), articulos[1]), crearDetallePedido(4L, 3,  articulos[4].getPrecioVenta()*3, articulos[7])}, cliente2);
        
        Pedido pedido3 = crearPedido(3L, LocalTime.of(20, 30), Pedido.EstadoPedido.FINALIZADO, Pedido.TipoEnvio.DOMICILIO, Pedido.FormaPago.TRANSFERENCIA_BANCARIA, LocalDate.of(2024, 9, 1),
                new DetallePedido[]{crearDetallePedido(5L, 1, articulos[0].getPrecioVenta(), articulos[0]), crearDetallePedido(6L, 1, articulos[0].getPrecioVenta(), articulos[5]), crearDetallePedido(7L, 1, articulos[2].getPrecioVenta(), articulos[2]), crearDetallePedido(8L, 2, articulos[6].getPrecioVenta()*2, articulos[6])}, cliente3);
        
        Pedido pedido4 = crearPedido(4L, LocalTime.of(19, 50), Pedido.EstadoPedido.EN_PROCESO, Pedido.TipoEnvio.DOMICILIO, Pedido.FormaPago.TARJETA_CREDITO, LocalDate.of(2024, 9, 3),
                new DetallePedido[]{crearDetallePedido(9L, 1,  articulos[5].getPrecioVenta(), articulos[5]), crearDetallePedido(10L, 1, articulos[6].getPrecioVenta(), articulos[6])}, cliente1);

        mostrarComprasCliente(cliente1);

        mostrarArticulos(articulos);
    }
    
    public static void mostrarPedido(Pedido pedido) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("PEDIDO " + pedido.getId());
        System.out.println("Hora Estimada de Finalización: " + pedido.getHoraEstimadaFinalizacion());
        System.out.println("Fecha del Pedido: " + pedido.getFechaPedido());
        System.out.println("Estado: " + pedido.getEstado());
        System.out.println("Tipo de Envío: " + pedido.getTipoEnvio());
        System.out.println("Forma de Pago: " + pedido.getFormaPago());
        System.out.println("\nDetalles del Pedido:");
        for (DetallePedido detalle : pedido.getDetalles()) {
            System.out.println(detalle);
        }
        System.out.println("***************");
        System.out.println("TOTAL: $" + pedido.getTotal());
    }
    
    private static void mostrarComprasCliente(Cliente cliente) {
        System.out.println("----------------------------------");
        int cantidadCompras = cliente.getHace().size();
        System.out.println("El cliente " + cliente.getNombre() + " ha comprado " + cantidadCompras + " veces en el local.");
    }
    
    private static void mostrarArticulos(Articulo[] articulos) {
        System.out.println("----------------------------------");
        System.out.println("LISTA DE ARTICULOS:");
        for (Articulo articulo : articulos) {
            System.out.println("- " + articulo.getDenominacion());
        }
    }

    private static Cliente crearCliente(Long id, String nombre, String apellido, String telefono, String email, LocalDate fechaNacimiento) {
        return Cliente.builder()
                       .id(id).nombre(nombre).apellido(apellido).telefono(telefono).email(email).fechaNacimiento(fechaNacimiento).hace(new HashSet<>()).build();
    }
    
    private static UnidadMedida crearUnidadMedida(Long id, String denominacion) {
        return UnidadMedida.builder().id(id).denominacion(denominacion).build();
    }
    
    private static Imagen crearImagen(Long id, String denominacion) {
        return Imagen.builder().id(id).denominacion(denominacion).build();
    }
    
    private static Articulo crearArticulo(Long id, String denominacion, double precioVenta, double precioCompra, int stockActual, int stockMaximo, int tiempoEstimadoMinutos, UnidadMedida unidadMedida, Imagen imagen) {
        return Articulo.builder()
                       .id(id).denominacion(denominacion).precioVenta(precioVenta).precioCompra(precioCompra).stockActual(stockActual)
                       .stockMaximo(stockMaximo).tiempoEstimadoMinutos(tiempoEstimadoMinutos).unidadMedida(unidadMedida).imagen(imagen).build();
    }
    
    private static DetallePedido crearDetallePedido(Long id, int cantidad, double subTotal, Articulo articulo) {
        return DetallePedido.builder().id(id).cantidad(cantidad).subTotal(subTotal).articulo(articulo).build();
    }
    
    private static Pedido crearPedido(Long id, LocalTime horaEstimada, Pedido.EstadoPedido estado, Pedido.TipoEnvio tipoEnvio, Pedido.FormaPago formaPago, LocalDate fechaPedido, DetallePedido[] detalles, Cliente cliente) {
        HashSet<DetallePedido> detallesSet = new HashSet<>();
        double total = 0;
        for (DetallePedido detalle : detalles) {
            detallesSet.add(detalle);
            total += detalle.getSubTotal();
        }
        Pedido pedido = Pedido.builder()
                                .id(id).horaEstimadaFinalizacion(horaEstimada).total(total).estado(estado).tipoEnvio(tipoEnvio)
                                .formaPago(formaPago).fechaPedido(fechaPedido).detalles(detallesSet).build();
        cliente.getHace().add(pedido);
        mostrarPedido(pedido);
        return pedido;
    }
    
}