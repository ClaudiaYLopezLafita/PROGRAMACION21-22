package ENTREGABLE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Consulta {

    public static void empleadosOficinaMayor(){
        Connection connection = ConexionBD.getConnection();

        String sql = "SELECT e.*\n" +
                "FROM employees e \n" +
                "WHERE e.officeCode = (SELECT o.officeCode\n" +
                "FROM offices o INNER JOIN employees e \n" +
                "ON o.officeCode = e.officeCode\n" +
                "GROUP BY o.officeCode \n" +
                "ORDER BY COUNT(e.employeeNumber) DESC\n" +
                "LIMIT 1);";

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int numEmple = rs.getInt(1);
                String lastName = rs.getString(2);
                String firstame = rs.getString(3);
                String ext = rs.getString(4);
                String email = rs.getString(5);
                String officeCode = rs.getString(6);
                int reports = rs.getInt(7);
                String title = rs.getString(8);

                System.out.println("Num. Empleado: "+numEmple);
                System.out.println("Apellido: "+lastName);
                System.out.println("Nombre: "+firstame);
                System.out.println("Extension: "+ext);
                System.out.println("email: "+ email);
                System.out.println("Oficina: "+officeCode);
                System.out.println("Jefe: "+reports);
                System.out.println("Titulo: "+title);
                System.out.println("----------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static  void productosNoVendidos(){
        Connection connection = ConexionBD.getConnection();

        String sql = "SELECT p.*\n" +
                "FROM products p LEFT JOIN orderdetails o \n" +
                "ON p.productCode = o.productCode\n" +
                "WHERE o.orderNumber IS NULL;";

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                String codProduct = rs.getString(1);
                String name = rs.getString(2);
                String line = rs.getString(3);
                String scale = rs.getString(4);
                String vendor = rs.getString(5);
                String descripcion = rs.getString(6);
                int quantity = rs.getInt(7);
                double price = rs.getDouble(8);
                double msrp = rs.getDouble(9);

                System.out.println("Codigo: "+codProduct);
                System.out.println("Nombre: "+name);
                System.out.println("Categoria "+line);
                System.out.println("Escala: "+scale);
                System.out.println("Vendor: "+vendor);
                System.out.println("Descripcion: "+descripcion);
                System.out.println("Stock: "+quantity);
                System.out.println("Price: "+price);
                System.out.println("MSRP: "+msrp);
                System.out.println("-------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void informeCategoria(){
        Connection connection = ConexionBD.getConnection();
        Scanner sc = new Scanner(System.in);
        int totalCategoria =0;

        System.out.println("Indica el nombre de la categoria: ");
        String nombre = sc.nextLine();

        String sql = "SELECT p.productName, o.quantityOrdered \n" +
                "FROM products p INNER JOIN productlines p2 \n" +
                "ON p.productLine =p2.productLine \n" +
                "INNER JOIN orderdetails o ON p.productCode = o.productCode \n" +
                "WHERE p2.productLine = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            rs.next();
            totalCategoria = rs.getInt(2);
            while (rs.next()){
                String name = rs.getString(1);
                int quantity = rs.getInt(2);
                totalCategoria += quantity;

                System.out.println("Product: " + name);
                System.out.println("Cantidad: " + quantity);
            }
            System.out.println("Total productos de la categoria "+ nombre+": " + totalCategoria+" unidades");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
