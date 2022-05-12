package U9_T3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Staments {

    final static Scanner sc = new Scanner(System.in);

    public static void insertCustomers(){
        Connection connection = Conexion.getConnection();

        try {
            connection.setAutoCommit(false);

            System.out.println("1. customerNumber");
            int num = sc.nextInt();
            sc.nextLine();
            System.out.println("2. customerName ");
            String name = sc.nextLine();
            System.out.println("3. contactLastName");
            String lastName= sc.nextLine();
            System.out.println("4. contactFirstName");
            String firstName= sc.nextLine();
            System.out.println("5. phone");
            String phone= sc.nextLine();
            System.out.println("6. addressLine1");
            String address1= sc.nextLine();
            System.out.println("7. addressLine2");
            String address2= sc.nextLine();
            System.out.println("8. city");
            String city= sc.nextLine();
            System.out.println("9. state");
            String state= sc.nextLine();
            System.out.println("10. postalCode");
            String postalCode= sc.nextLine();
            System.out.println("11. country");
            String country= sc.nextLine();
            System.out.println("12. salesRepEmployeeNumber");
            int numRepresante = sc.nextInt();
            System.out.println("13. creditLimit");
            double credit = sc.nextDouble();

            String sql = "INSERT INTO customers VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, num);
            ps.setString(2, name);
            ps.setString(3, lastName);
            ps.setString(4, firstName);
            ps.setString(5, phone);
            ps.setString(6, address1);
            ps.setString(7, address2);
            ps.setString(8, city);
            ps.setString(9, state);
            ps.setString(10, postalCode);
            ps.setString(11, country);
            ps.setInt(12, numRepresante);
            ps.setDouble(13, credit);

            ps.executeUpdate();
            connection.commit(); // ojo que sino no se inserta
            System.out.println("Cliente insertado");

        } catch (SQLException e) {
            System.out.println("error: " +e.getMessage());
            try{
                if (connection!=null){
                    System.out.println("Dejamos la BBDD en estado consistente.");
                    connection.rollback();
                }
            } catch (SQLException throwables){
                System.out.println("Error en el rollback");
                throwables.printStackTrace();
            }
        }

    }

    public static void assignEmployeeCustomer(){
        Connection connection = Conexion.getConnection();

        try {
            connection.setAutoCommit(false);

            System.out.println("Indica en numero del empleado: ");
            int numEmpleado = sc.nextInt();
            System.out.println("Indica en numero del cliente: ");
            int numCliente = sc.nextInt();

            // comproacion de que existe cliente
            String sql = "SELECT COUNT(c.customerNumber) \n" +
                    "FROM customers c \n" +
                    "WHERE c.customerNumber = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, numCliente);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int existeCliente = rs.getInt(1);

            // comprobacion de que existe empleado
            String sql2 = "SELECT COUNT(e.employeeNumber) \n" +
                    "FROM employees e \n" +
                    "WHERE e.employeeNumber = ?";
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps2.setInt(1, numEmpleado);
            ResultSet rs2 = ps2.executeQuery();
            rs2.next();
            int existeEmpleado = rs2.getInt(1);

            if (existeEmpleado!=1 || existeCliente!=1) {
                System.out.println("El empleado o el cliente no existen, comprueba");
            }else  {

                String sql3 = "UPDATE customers SET salesRepEmployeeNumber = ? WHERE customerNumber = ?";
                PreparedStatement ps3 = connection.prepareStatement(sql3);

                ps3.setInt(1, numEmpleado);
                ps3.setInt(2, numCliente);

                ps3.executeUpdate();
                connection.commit();
                System.out.println("Empleado asignado a cliente");
            }
        } catch (SQLException e) {
            System.out.println("error: " +e.getMessage());
            try{
                if (connection!=null){
                    System.out.println("Dejamos la BBDD en estado consistente.");
                    connection.rollback();
                }
            } catch (SQLException throwables){
                System.out.println("Error en el rollback");
                throwables.printStackTrace();
            }
        }
    }

    public static void addProductToOrders(){
        Connection connection = Conexion.getConnection();

        try {
            connection.setAutoCommit(false);

            System.out.println("Codigo del producto: ");
            String codProducto = sc.nextLine();
            sc.nextLine();
            System.out.println("Cantidad del producto: ");
            int cantidad = sc.nextInt();
            System.out.println("Codigo del pedido: ");
            int codPedido = sc.nextInt();

            // Comprobacion de existencia de prodcuto
            String sql = "SELECT COUNT(p.productCode) \n" +
                    "FROM products p \n" +
                    "WHERE p.productCode = ?; ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, codProducto);

            ResultSet rs = ps.executeQuery();
            rs.next();
            int existeProduct = rs.getInt(1);

            // Comprobacion de la existencia de
            String sql1 = "SELECT COUNT(o.orderNumber) \n" +
                    "FROM orders o \n" +
                    "WHERE o.orderNumber = ?;";

            PreparedStatement ps2 = connection.prepareStatement(sql1);
            ps2.setInt(1, codPedido);

            ResultSet rs2 = ps2.executeQuery();
            rs2.next();
            int existePedido = rs2.getInt(1);


            if (existeProduct!=1 || existePedido!=1){
                System.out.println("El pedido o el prducto no existe, comprueba");
            }else {
                String sql3 = "INSERT INTO orderdetails VALUES (?,?,?,?,?);";
                PreparedStatement ps3 = connection.prepareStatement(sql3);

                ps3.setInt(1, codPedido);
                ps3.setString(2, codProducto);
                ps3.setInt(3, cantidad);
                ps3.setDouble(4, 2.3);
                ps3.setInt(5, 10);

                ps3.executeUpdate();
                connection.commit();
                System.out.println("Producto añadido al pedido.");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void detailsOrder(){
        Connection connection = Conexion.getConnection();

        System.out.println("Indica el codigo del pedido.");
        int codPedido = sc.nextInt();

        String sql = "SELECT  p.productName, o2.quantityOrdered , o2.priceEach, (o2.quantityOrdered*o2.priceEach)\n" +
                "FROM orderdetails o2\n" +
                "INNER JOIN products p \n" +
                "ON o2.productCode = p.productCode \n" +
                "WHERE o2.orderNumber = ?;";

        PreparedStatement statement = null;
        int totalPedido = 0;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, codPedido);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("productName");
                int quantity = rs.getInt("quantityOrdered");
                int price = rs.getInt("priceEach");
                int total = rs.getInt(4);
                totalPedido += total;

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

}
