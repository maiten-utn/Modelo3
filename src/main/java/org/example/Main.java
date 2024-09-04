package org.example;

import jdk.swing.interop.SwingInterOpUtils;
import org.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = Cliente.builder()
                .id(1L).nombre("Juan Cruz")
                .apellido("Robledo")
                .telefono("2613748327")
                .email("juan@gmail.com")
                .fechaNacimiento(LocalDate.of(2004,9,6)).build();
        Cliente cliente2 = Cliente.builder()
                .id(2L).nombre("Santiago")
                .apellido("Robledo")
                .telefono("2614829832")
                .email("santiago@gmail.com")
                .fechaNacimiento(LocalDate.of(2003,8,3)).build();
        Cliente cliente3 = Cliente.builder()
                .id(1L).nombre("Martin")
                .apellido("Robledo")
                .telefono("2615829485")
                .email("martin@gmail.com")
                .fechaNacimiento(LocalDate.of(1992,9,11)).build();

        //Creacion unidadMedida
        UnidadMedida unidadMedida = UnidadMedida.builder().denominacion("8 Porciones").id(1L).build();
        UnidadMedida unidadMedida2 = UnidadMedida.builder().denominacion("4 Porciones").id(2L).build();
        UnidadMedida unidadMedida3 = UnidadMedida.builder().denominacion("1Litro").id(3L).build();

        //Creacion de Imagenes
        Imagen imagen1 = Imagen.builder().denominacion("Imagen Pizza grande hawaiana").id(1L).build();
        Imagen imagen2 = Imagen.builder().denominacion("Imagen Pizza grande napolitana").id(2L).build();
        Imagen imagen3 = Imagen.builder().denominacion("Imagen Pizza grande muzza").id(3L).build();

        Imagen imagen4 = Imagen.builder().denominacion("Imagen Pizza chica hawaiana").id(4L).build();
        Imagen imagen5 = Imagen.builder().denominacion("Imagen Pizza chica napolitana").id(5L).build();
        Imagen imagen6 = Imagen.builder().denominacion("Imagen Pizza chica muzza").id(6L).build();

        Imagen imagen7 = Imagen.builder().denominacion("Imagen Cerveza Andes").id(7L).build();
        Imagen imagen8 = Imagen.builder().denominacion("Imagen Cerveza Quilmes").id(8L).build();

        //Creacion de Articulos
        Articulo grandeHawaiana = Articulo.builder()
                .id(1L).denominacion("Pizza grande Hawaiana,").precioVenta(100.0).precioCompra(35.0).stockActual(20).stockMaximo(25).unidadMedida(unidadMedida).imagen(imagen1).tiempoEstimadoEnMin(30).build();
        Articulo chicaHawaiana = Articulo.builder()
                .id(2L).denominacion("Pizza chica Hawaiana,").precioVenta(60.0).precioCompra(20.0).stockActual(20).stockMaximo(25).unidadMedida(unidadMedida2).imagen(imagen4).tiempoEstimadoEnMin(20).build();
        Articulo grandeNapolitana = Articulo.builder()
                .id(3L).denominacion("Pizza grande Napolitana,").precioVenta(135.0).precioCompra(50.0).stockActual(14).stockMaximo(25).unidadMedida(unidadMedida).imagen(imagen2).tiempoEstimadoEnMin(30).build();
        Articulo chicaNapolitana = Articulo.builder()
                .id(4L).denominacion("Pizza chica Napolitana,").precioVenta(75.0).precioCompra(25.0).stockActual(3).stockMaximo(25).unidadMedida(unidadMedida2).imagen(imagen5).tiempoEstimadoEnMin(20).build();
        Articulo grandeMuzza = Articulo.builder()
                .id(5L).denominacion("Pizza grande Muzza,").precioVenta(135.0).precioCompra(50.0).stockActual(14).stockMaximo(25).unidadMedida(unidadMedida).imagen(imagen3).tiempoEstimadoEnMin(30).build();
        Articulo chicaMuzza = Articulo.builder()
                .id(6L).denominacion("Pizza chica Muzza,").precioVenta(50.0).precioCompra(20.0).stockActual(10).stockMaximo(25).unidadMedida(unidadMedida2).imagen(imagen6).tiempoEstimadoEnMin(20).build();
        Articulo cervezaAndes = Articulo.builder()
                .id(7L).denominacion("Cerveza Andes").precioVenta(30.0).precioCompra(20.0).stockActual(35).stockMaximo(50).unidadMedida(unidadMedida3).tiempoEstimadoEnMin(0).imagen(imagen7).build();
        Articulo cervezaQuilmes = Articulo.builder()
                .id(8L).denominacion("Cerveza Quilmes").precioVenta(20.0).precioCompra(12.0).stockActual(22).stockMaximo(35).unidadMedida(unidadMedida3).tiempoEstimadoEnMin(0).imagen(imagen8).build();



        boolean salir = false;



        //CLIENTE 1
        //Pedido 1
        Set<Pedido> pedidosLista1 = new HashSet<>();
        DetallePedido detallePedidoPizza1 = new DetallePedido(1L ,1,grandeHawaiana.getPrecioVenta(),grandeHawaiana);
        DetallePedido detallePedidoCerveza1 = new DetallePedido(1L  ,1,cervezaQuilmes.getPrecioVenta(),cervezaQuilmes);
        Set<DetallePedido> detalles1 = new HashSet<>();
        detalles1.add(detallePedidoPizza1);
        detalles1.add(detallePedidoCerveza1);
        LocalTime horaActual1 = LocalTime.now();
        LocalDate fechaActual1 = LocalDate.now();
        Pedido pedido1 = Pedido.builder()
                .id(1L)
                .horaEstimadaFinalizacion(horaActual1.plusMinutes(30))
                .estado(Estado.PENDIENTE)
                .tipoEnvio(TipoEnvio.LOCAL)
                .formaPago(FormaPago.EFECTIVO)
                .fechaPedido(fechaActual1)
                .detalles(detalles1).build();
        pedido1.calcularTotal();
        pedidosLista1.add(pedido1);
        cliente1.setPedidos(pedidosLista1);
        //Pedido 2
        DetallePedido detallePedidoPizza1_2 = new DetallePedido(4L ,1,chicaMuzza.getPrecioVenta(),chicaMuzza);
        DetallePedido detallePedidoCerveza1_2 = new DetallePedido(4L  ,1,cervezaAndes.getPrecioVenta(),cervezaAndes);
        Set<DetallePedido> detalles1_2 = new HashSet<>();
        detalles1_2.add(detallePedidoPizza1_2);
        detalles1_2.add(detallePedidoCerveza1_2);
        LocalTime horaActual1_2 = LocalTime.now();
        LocalDate fechaActual1_2 = LocalDate.now();
        Pedido pedido1_2 = Pedido.builder()
                .id(2L)
                .horaEstimadaFinalizacion(horaActual1_2.plusMinutes(30))
                .estado(Estado.PENDIENTE)
                .tipoEnvio(TipoEnvio.LOCAL)
                .formaPago(FormaPago.EFECTIVO)
                .fechaPedido(fechaActual1_2.plusDays(1))
                .detalles(detalles1_2).build();
        pedido1_2.calcularTotal();
        pedidosLista1.add(pedido1_2);
        cliente1.setPedidos(pedidosLista1);

        //CLIENTE 2
        //Pedido 1
        Set<Pedido> pedidosLista2 = new HashSet<>();
        DetallePedido detallePedidoPizza2 = new DetallePedido(2L ,1,chicaHawaiana.getPrecioVenta(),chicaHawaiana);
        DetallePedido detallePedidoCerveza2 = new DetallePedido(2L ,3,cervezaQuilmes.getPrecioVenta(),cervezaQuilmes);
        Set<DetallePedido> detalles2 = new HashSet<>();
        detalles2.add(detallePedidoPizza2);
        detalles2.add(detallePedidoCerveza2);
        LocalTime horaActual2 = LocalTime.now();
        LocalDate fechaActual2 = LocalDate.now();
        Pedido pedido2 = Pedido.builder()
                .id(3L)
                .horaEstimadaFinalizacion(horaActual2.plusMinutes(30))
                .estado(Estado.PENDIENTE)
                .tipoEnvio(TipoEnvio.LOCAL)
                .formaPago(FormaPago.EFECTIVO)
                .fechaPedido(fechaActual2)
                .detalles(detalles2).build();
        pedido2.calcularTotal();
        pedidosLista2.add(pedido2);
        cliente2.setPedidos(pedidosLista2);
        //CLIENTE 3
        //Pedido 1
        Set<Pedido> pedidosLista3 = new HashSet<>();
        DetallePedido detallePedidoPizza3_1 = new DetallePedido(3L ,1,grandeHawaiana.getPrecioVenta(),grandeHawaiana);
        DetallePedido detallePedidoPizza3_2 = new DetallePedido(3L ,1,chicaMuzza.getPrecioVenta(),chicaMuzza);
        DetallePedido detallePedidoPizza3_3 = new DetallePedido(3L ,1,grandeNapolitana.getPrecioVenta(),grandeNapolitana);
        DetallePedido detallePedidoCerveza3 = new DetallePedido(3L ,2,cervezaAndes.getPrecioVenta(),cervezaAndes);
        Set<DetallePedido> detalles3 = new HashSet<>();
        detalles3.add(detallePedidoPizza3_1);
        detalles3.add(detallePedidoPizza3_2);
        detalles3.add(detallePedidoPizza3_3);
        detalles3.add(detallePedidoCerveza3);
        LocalTime horaActual3 = LocalTime.now();
        LocalDate fechaActual3 = LocalDate.now();
        Pedido pedido3 = Pedido.builder()
                .id(4L)
                .horaEstimadaFinalizacion(horaActual3.plusMinutes(30))
                .estado(Estado.PENDIENTE)
                .tipoEnvio(TipoEnvio.LOCAL)
                .formaPago(FormaPago.EFECTIVO)
                .fechaPedido(fechaActual3)
                .detalles(detalles3).build();
        pedido3.calcularTotal();
        pedidosLista3.add(pedido3);
        cliente3.setPedidos(pedidosLista3);

        while (!salir) {
            System.out.println("\n*****************************");
            System.out.println("1-Mostrar pedido 1 cliente 1");
            System.out.println("2-Mostrar pedido cliente 2");
            System.out.println("3-Mostrar pedido cliente 3");
            System.out.println("4-Mostrar pedido 2 cliente 1");
            System.out.println("5-Mostrar cliente 1");
            System.out.println("6-Mostrar productos");
            System.out.println("Otro- Salir\n");
            Scanner leerNum = new Scanner(System.in);
            int numero = leerNum.nextInt();
            int num;
            List<Pedido> listPedidos;
            List<Articulo> articulosLista = new ArrayList<>();
            Collections.addAll(articulosLista,grandeHawaiana,chicaHawaiana,grandeNapolitana,chicaNapolitana,grandeMuzza,chicaMuzza,cervezaAndes,cervezaQuilmes);

            switch (numero) {
                case 1:
                    System.out.println("********************CLIENTE 1********************");
                    System.out.println(cliente1);
                    System.out.println("-----PEDIDO 1-----");
                    listPedidos = new ArrayList<>(cliente1.getPedidos());
                    System.out.println(listPedidos.get(0));
                    System.out.println("-----DETALLES PEDIDO 1-----");

                    num = 1;
                    for (DetallePedido detalle : listPedidos.get(0).getDetalles()){
                        System.out.println("** DETALLE DE PRODUCTO "+ num +" **");
                        System.out.println(detalle);

                        System.out.println("\nARTICULO:");
                        System.out.println(detalle.getArticulo());
                        num +=1;
                    }

                    break;
                case 2:
                    System.out.println("********************CLIENTE 2********************");
                    System.out.println(cliente2);
                    System.out.println("-----PEDIDO 1-----");
                    listPedidos = new ArrayList<>(cliente2.getPedidos());
                    System.out.println(listPedidos.get(0).toString());
                    System.out.println("-----DETALLES PEDIDO 1-----");
                    num = 1;
                    for (DetallePedido detalle : listPedidos.get(0).getDetalles()){
                        System.out.println("** DETALLE DE PRODUCTO "+ num +" **");
                        System.out.println(detalle);

                        System.out.println("\nARTICULO:");
                        System.out.println(detalle.getArticulo());
                        num +=1;
                    }
                    break;
                case 3:
                    System.out.println("********************CLIENTE 3********************");
                    System.out.println(cliente3);
                    System.out.println("-----PEDIDO 1-----");
                    listPedidos = new ArrayList<>(cliente3.getPedidos());
                    System.out.println(listPedidos.get(0).toString());
                    System.out.println("-----DETALLES PEDIDO 1-----");
                    num = 1;
                    for (DetallePedido detalle : listPedidos.get(0).getDetalles()){
                        System.out.println("** DETALLE DE PRODUCTO "+ num +" **");
                        System.out.println(detalle);

                        System.out.println("\nARTICULO:");
                        System.out.println(detalle.getArticulo());
                        num +=1;
                    }
                    break;
                case 4:
                    System.out.println("********************CLIENTE 1********************");
                    System.out.println(cliente1);
                    System.out.println("-----PEDIDO 2-----");
                    listPedidos = new ArrayList<>(cliente1.getPedidos());
                    System.out.println(listPedidos.get(1).toString());
                    System.out.println("-----DETALLES PEDIDO 1-----");
                    num = 1;
                    for (DetallePedido detalle : listPedidos.get(1).getDetalles()){
                        System.out.println("** DETALLE DE PRODUCTO "+ num +" **");
                        System.out.println(detalle);

                        System.out.println("\nARTICULO:");
                        System.out.println(detalle.getArticulo());
                        num +=1;
                    }
                    break;
                case 5:
                    System.out.println("********************CLIENTE 1********************");
                    num = 1;
                    for (Pedido p : cliente1.getPedidos()){
                        System.out.println("----- PEDIDO " + num +" -----");
                        System.out.println(p);
                        num+=1;
                    }
                    System.out.println("CANTIDAD DE VECES QUE COMPRO EN EL LOCAL: "+ num);

                    break;
                case 6:
                    System.out.println("******************** ARTICULOS 1********************");
                    num = 1;
                    for (Articulo art : articulosLista){
                        System.out.println("----- ARTICULO " + num +" -----");
                        System.out.println(art);
                        num+=1;
                    }
                    break;
                default:
                    salir = true;
                    break;
            }
        }
    }
}