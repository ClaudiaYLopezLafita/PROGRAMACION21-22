package ENTREGABLE;

import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {

        System.out.println("Informe de los productos por categoria");
       Consulta.informeCategoria();

        System.out.println("Empleados de la oficina con mayor empleados");
        Consulta.empleadosOficinaMayor();

        System.out.println("Prodcutos no vendidos.");
        Consulta.productosNoVendidos();

        System.out.println("Nuevo cliente con pago");
        Transacciones.insertCustomerPayment();

        System.out.println("Actualizacion de oficina");
        Transacciones.updateOffice();

    }
}
