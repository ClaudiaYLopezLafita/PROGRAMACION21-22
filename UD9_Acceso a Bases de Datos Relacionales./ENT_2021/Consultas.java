package ENT_2021;

import java.sql.*;
import java.util.Scanner;

public class Consultas {

    public static void pagosCliente() {
        Connection con = Conexion.getConnection();
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el número del clientes: ");
        int numCliente = sc.nextInt();

        try {

            String sql = "SELECT c.contactFirstName , c.contactLastName , c.country , SUM(p.amount)\n" +
                    "FROM customers c \n" +
                    "INNER JOIN payments p \n" +
                    "ON c.customerNumber =p.customerNumber \n" +
                    "WHERE c.customerNumber =" + numCliente;
            Statement statement = con.prepareStatement(sql);

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                String name = rs.getString("contactFirstName");
                String address = rs.getString("contactLastName");
                String country = rs.getString("country");
                int total = rs.getInt(4);

                System.out.println("---------" + "Cliente:" + numCliente + "----------------");
                System.out.println("Nombre: " + name);
                System.out.println("Apellido: " + address);
                System.out.println("Pais: " + country);
                System.out.println("TOTAL PAGOS: " + total);
                System.out.println("-------------------------");
            }

        } catch (SQLException e) {
//            throw new RuntimeException(e);
        }
    }

    public static void infoPedido() {
        Connection con = Conexion.getConnection();
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el número del pedido: ");
        int orderNumber = sc.nextInt();

        String sql = "SELECT  p.productName, o2.quantityOrdered , o2.priceEach, (o2.quantityOrdered*o2.priceEach)\n" +
                "FROM orderdetails o2\n" +
                "INNER JOIN products p \n" +
                "ON o2.productCode = p.productCode \n" +
                "WHERE o2.orderNumber = ?;";

        PreparedStatement statement = null;
        int totalPedido = 0;
        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, orderNumber);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("productName");
                int quantity = rs.getInt("quantityOrdered");
                int price = rs.getInt("priceEach");
                int total = rs.getInt(4);
                totalPedido += total;

                System.out.println("-------------------------");
                System.out.println("Nombre Product: " + name);
                System.out.println("Cantidad: " + quantity);
                System.out.println("Precio Unidad: " + price);
                System.out.println("Total: " + total);
                System.out.println("-------------------------");
            }
            System.out.println("Total pedido: " + totalPedido + "€");
        } catch (SQLException e) {
//            throw new RuntimeException(e);
        }


    }

    public static void datosJefe() {
        Connection con = Conexion.getConnection();
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el número del pedido: ");
        int numEmployees = sc.nextInt();

        String sql = "SELECT e2.firstName, e2.lastName  \n" +
                "FROM employees e INNER JOIN employees e2 \n" +
                "ON e.reportsTo  = e2.employeeNumber  \n" +
                "WHERE e.employeeNumber  = ?";

        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, numEmployees);
            ResultSet rs = statement.executeQuery();

            rs.next();
            String name = rs.getString("firstName");
            String lastName = rs.getString("lastName");

            System.out.println("------------"+"JEFE"+"-------------");
            System.out.println("Nombre: " + name);
            System.out.println("Apellido: " + lastName);
            System.out.println("-------------------------");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}