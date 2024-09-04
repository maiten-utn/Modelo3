package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //CREACION DE CLIENTES
        Cliente cliente1 = Cliente.builder().id(1L).nombre("Juan").apellido("Pérez").telefono("123456789").email("juan.perez@example.com").fechaNacimiento(LocalDate.of(1990, 5, 20)).build();
        Cliente cliente2 = Cliente.builder().id(2L).nombre("María").apellido("García").telefono("987654321").email("maria.garcia@example.com").fechaNacimiento(LocalDate.of(1985, 8, 15)).build();
        Cliente cliente3 = Cliente.builder().id(3L).nombre("Carlos").apellido("López").telefono("555123456").email("carlos.lopez@example.com").fechaNacimiento(LocalDate.of(2000, 1, 10)).build();

        //CREACION DE UNIDAD DE MEDIDAS
        UnidadMedida ochoPorciones = UnidadMedida.builder().id(1L).denominacion("Ocho porciones").build();
        UnidadMedida cuatroPorciones = UnidadMedida.builder().id(2L).denominacion("Cuatro porciones").build();
        UnidadMedida unLitro = UnidadMedida.builder().id(3L).denominacion("Un litro").build();

        //CREACION DE IMAGENES
        Imagen imagen1 = Imagen.builder().id(1L).nombre("Imagen Pizza Grande Hawaiana").url("https://www.hogarmania.com/archivos/202401/pizza-hawaiana-1280x720x80xX.jpg").build();
        Imagen imagen2 = Imagen.builder().id(2L).nombre("Imagen Pizza Grande Napolitana").url("https://mandolina.co/wp-content/uploads/2023/08/pizza-napolitana-1080x550-1.png").build();
        Imagen imagen3 = Imagen.builder().id(3L).nombre("Imagen Pizza Grande Muzzarella").url("https://quem.com.ar/tienda/wp-content/uploads/2018/05/Pizza-e1584547627773.jpg").build();
        Imagen imagen4 = Imagen.builder().id(4L).nombre("Imagen Pizza Chica Hawaiana").url("https://i.blogs.es/ad0e95/como-preparar-pizza-con-pina-1-/450_1000.jpg").build();
        Imagen imagen5 = Imagen.builder().id(5L).nombre("Imagen Pizza Chica Napolitana").url("https://osojimix.com/wp-content/uploads/2022/06/Para-la-masa-de-pizza-napolitana-8-hrs-fermentacion-Web-1.jpg").build();
        Imagen imagen6 = Imagen.builder().id(6L).nombre("Imagen Pizza Chica Muzzarella").url("https://saboresmendoza.com/wp-content/uploads/2024/02/pizza-de-muzzarella-sabores.jpg").build();
        Imagen imagen7 = Imagen.builder().id(7L).nombre("Imagen Cerveza Andes").url("https://atomoconviene.com/atomo-ecommerce/66350-large_default/cerveza-andes-lata-473-cc--.jpg").build();
        Imagen imagen8 = Imagen.builder().id(8L).nombre("Imagen Cerveza Quilmes").url("https://cepadevinos.com/wp-content/uploads/2021/01/7792798012923_02_nuevopack.jpg").build();

        //CREACION DE ARTÍCULOS
        Articulo grandeHawaiana = Articulo.builder()
                .id(1L).denominacion("Pizza Grande Hawaiana").precioVenta(100.0).precioCompra(35.0).stockActual(20).stockMaximo(25).unidadMedida(ochoPorciones).imagen(imagen1).tiempoEstimadoMinutos(30).build();
        Articulo chicaHawaiana = Articulo.builder()
                .id(2L).denominacion("Pizza Chica Hawaiana").precioVenta(60.0).precioCompra(20.0).stockActual(20).stockMaximo(25).unidadMedida(cuatroPorciones).imagen(imagen4).tiempoEstimadoMinutos(30).build();
        Articulo grandeNapolitana = Articulo.builder()
                .id(3L).denominacion("Pizza Grande Napolitana").precioVenta(135.0).precioCompra(50.0).stockActual(14).stockMaximo(25).unidadMedida(ochoPorciones).imagen(imagen2).tiempoEstimadoMinutos(35).build();
        Articulo chicaNapolitana = Articulo.builder()
                .id(4L).denominacion("Pizza Chica Napolitana").precioVenta(75.0).precioCompra(25.0).stockActual(3).stockMaximo(25).unidadMedida(cuatroPorciones).imagen(imagen5).tiempoEstimadoMinutos(35).build();
        Articulo grandeMuzza = Articulo.builder()
                .id(5L).denominacion("Pizza Grande Muzzarella").precioVenta(135.0).precioCompra(50.0).stockActual(14).stockMaximo(25).unidadMedida(ochoPorciones).imagen(imagen3).tiempoEstimadoMinutos(20).build();
        Articulo chicaMuzza = Articulo.builder()
                .id(6L).denominacion("Pizza Chica Muzzarella").precioVenta(50.0).precioCompra(20.0).stockActual(10).stockMaximo(25).unidadMedida(cuatroPorciones).imagen(imagen6).tiempoEstimadoMinutos(20).build();
        Articulo cervezaAndes = Articulo.builder()
                .id(7L).denominacion("Cerveza Andes").precioVenta(30.0).precioCompra(20.0).stockActual(35).stockMaximo(50).unidadMedida(unLitro).imagen(imagen7).tiempoEstimadoMinutos(0).build();
        Articulo cervezaQuilmes = Articulo.builder()
                .id(8L).denominacion("Cerveza Quilmes").precioVenta(20.0).precioCompra(12.0).stockActual(22).stockMaximo(35).unidadMedida(unLitro).imagen(imagen8).tiempoEstimadoMinutos(0).build();
//////////////////////////////////////////////////////////////////////////////////////////////////
        //PEDIDO CLIENTE 1 | realiza un pedido de una Pizza grande (Hawaiana) y una cerveza Quilmes.
        DetallePedido detalle1cliente1 = DetallePedido.builder().id(1L).articulo(grandeHawaiana).cantidad(1).build();
        detalle1cliente1.calcularSubTotal();

        DetallePedido detalle2cliente1 = DetallePedido.builder().id(2L).articulo(cervezaQuilmes).cantidad(1).build();
        detalle2cliente1.calcularSubTotal();

        Pedido pedido1cliente1 = Pedido.builder()
                .id(1L)
                .horaEstimadaFinalizacion(LocalTime.of(21, 0))
                .detallePedido(Set.of(detalle1cliente1, detalle2cliente1))
                .estado(Estado.EN_PREPARACION)
                .tipoEnvio(TipoEnvio.RETIRO_LOCAL)
                .formaPago(FormaPago.EFECTIVO)
                .fechaPedido(LocalDate.of(2024, 9, 4))
                .build();
        pedido1cliente1.calcularTotales();

        cliente1.getPedidos().add(pedido1cliente1);
//////////////////////////////////////////////////////////////////////////////////////////////////
        //PEDIDO CLIENTE 2 | realiza la compra de 3 cervezas Quilmes y una Pizza Hawaiana chica.
        DetallePedido detalle1cliente2 = DetallePedido.builder().id(1L).articulo(cervezaQuilmes).cantidad(3).build();
        detalle1cliente2.calcularSubTotal();

        DetallePedido detalle2cliente2 = DetallePedido.builder().id(2L).articulo(chicaHawaiana).cantidad(1).build();
        detalle2cliente2.calcularSubTotal();

        Pedido pedido1cliente2 = Pedido.builder()
                .id(2L)
                .horaEstimadaFinalizacion(LocalTime.of(22, 15))
                .detallePedido(Set.of(detalle1cliente2, detalle2cliente2))
                .estado(Estado.LISTO)
                .tipoEnvio(TipoEnvio.COMUN)
                .formaPago(FormaPago.TCREDITO)
                .fechaPedido(LocalDate.of(2024, 9, 4))
                .build();
        pedido1cliente2.calcularTotales();

        cliente2.getPedidos().add(pedido1cliente2);
//////////////////////////////////////////////////////////////////////////////////////////////////
        //PEDIDO CLIENTE 3 | compra 1 Pizza grande Hawaiana , 1 pizza chica Muzza , 1 grande Napolitana y 2 cervezas Andes.
        DetallePedido detalle1cliente3 = DetallePedido.builder().id(3L).articulo(grandeHawaiana).cantidad(1).build();
        detalle1cliente3.calcularSubTotal();

        DetallePedido detalle2cliente3 = DetallePedido.builder().id(4L).articulo(grandeNapolitana).cantidad(1).build();
        detalle2cliente3.calcularSubTotal();

        DetallePedido detalle3cliente3 = DetallePedido.builder().id(5L).articulo(cervezaAndes).cantidad(2).build();
        detalle3cliente3.calcularSubTotal();

        Pedido pedido1cliente3 = Pedido.builder()
                .id(3L)
                .horaEstimadaFinalizacion(LocalTime.of(22, 30))
                .detallePedido(Set.of(detalle1cliente3, detalle2cliente3, detalle3cliente3))
                .estado(Estado.SIN_EMPEZAR)
                .tipoEnvio(TipoEnvio.EXPRESS)
                .formaPago(FormaPago.TDEBITO)
                .fechaPedido(LocalDate.of(2024, 9, 4))
                .build();
        pedido1cliente3.calcularTotales();

        cliente3.getPedidos().add(pedido1cliente3);
//////////////////////////////////////////////////////////////////////////////////////////////////
        //PEDIDO 2 CLIENTE 1 | realiza un pedido de 1 muzza chica y una cerveza Andes.
        DetallePedido detalle3cliente1 = DetallePedido.builder().id(6L).articulo(chicaMuzza).cantidad(1).build();
        detalle3cliente1.calcularSubTotal();

        DetallePedido detalle4cliente1 = DetallePedido.builder().id(7L).articulo(cervezaAndes).cantidad(1).build();
        detalle4cliente1.calcularSubTotal();

        Pedido pedido2cliente1 = Pedido.builder()
                .id(4L)
                .horaEstimadaFinalizacion(LocalTime.of(20, 45))
                .detallePedido(Set.of(detalle3cliente1, detalle4cliente1))
                .estado(Estado.LISTO)
                .tipoEnvio(TipoEnvio.RETIRO_LOCAL)
                .formaPago(FormaPago.TDEBITO)
                .fechaPedido(LocalDate.of(2024, 9, 8))
                .build();
        pedido2cliente1.calcularTotales();

        cliente1.getPedidos().add(pedido2cliente1);
        //////////////////////////////////////////////////////////////////////////////////////////////////
        Set<Cliente> todosLosClientes = new HashSet<>(Set.of(cliente1, cliente2, cliente3));
        //MOSTRAR POR CONSOLA
        for (Cliente cliente : todosLosClientes) {
            System.out.println("-----------------\nCLIENTE " + cliente.getId() + " | " + cliente.getNombre() + " " + cliente.getApellido() + "\n-----------------");
            for (Pedido pedido : cliente.getPedidos()) {
                System.out.println("Pedido: " + pedido.toString() + "\n ***");
                for (DetallePedido detalle : pedido.getDetallePedido()) {
                    System.out.println(detalle.getArticulo().getDenominacion() + " x" + detalle.getCantidad() + " - $" + detalle.getSubTotal());
                }
                System.out.println("TOTAL: " + pedido.getTotal());
            }
        }

        System.out.println("-------------------------------------");
        System.out.println("EL CLIENTE 1 HA COMPRADO EN EL LOCAL " + cliente1.getPedidos().size() + " VECES");
        System.out.println("-------------------------------------");

        System.out.println("ARTÍCULOS:");
        HashSet<Articulo> todosLosArticulos = new HashSet<>(Set.of(grandeHawaiana, chicaHawaiana, grandeNapolitana, chicaNapolitana, grandeMuzza, chicaMuzza, cervezaAndes, cervezaQuilmes));
        for (Articulo art : todosLosArticulos) {
            System.out.println(art.toString());
        }
    }
}