package ENTREGABLE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transacciones {

    public static void insertCustomerPayment(){
        Connection connection = ConexionBD.getConnection();
        try {
            connection.setAutoCommit(false);

            String sql = "INSERT INTO customers VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, 3001);
            ps.setString(2, "CrazyCAT");
            ps.setString(3, "Lopez");
            ps.setString(4, "Claudia");
            ps.setString(5, "123456789");
            ps.setString(6, "address1");
            ps.setString(7, "address2");
            ps.setString(8, "Sevilla");
            ps.setString(9, "Andalucia");
            ps.setString(10, "41003");
            ps.setString(11, "España");
            ps.setInt(12, 1002);
            ps.setDouble(13, 10.2);

            ps.executeUpdate();
            connection.commit();
            System.out.println("Cliente insertado");

            sql = "INSERT INTO payments VALUES (?,?,?,?)";
            ps = connection.prepareStatement(sql);

            ps.setInt(1, 3001);
            ps.setString(2,"LSD12345");
            ps.setString(3,"2004-03-10");
            ps.setDouble(4, 123.5);

            ps.executeUpdate();
            connection.commit();
            System.out.println("Pago registrado");

            sql = "INSERT INTO payments VALUES (?,?,?,?)";
            ps = connection.prepareStatement(sql);

            ps.setInt(1, 3000);
            ps.setString(2,"CAT12345");
            ps.setString(3,"2010-012-10");
            ps.setDouble(4, 5.5);

            ps.executeUpdate();
            connection.commit();
            System.out.println("Pago registrado");


        } catch (SQLException e) {
            System.out.println("error: " +e.getMessage());
            try{
                if (connection!=null){
                    System.out.println("BBDD en estado consistente.");
                    connection.rollback();
                }
            } catch (SQLException throwables){
                System.out.println("Error en el rollback");
                throwables.printStackTrace();
            }
        }

    }

    public static void updateOffice(){
        Connection connection = ConexionBD.getConnection();

        try {
            connection.setAutoCommit(false);

            String sql = "INSERT INTO offices VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, "100");
            ps.setString(2, "Tokyo");
            ps.setString(3,"123456789");
            ps.setString(4,"Akihabara");
            ps.setString(5, "address2");
            ps.setString(6, "KKKK");
            ps.setString(7, "Japan");
            ps.setString(8, "4686");
            ps.setString(9,"ASF");

            ps.executeUpdate();
            connection.commit();
            System.out.println("Oficina Resgistrada.");

            sql = "UPDATE employees e SET e.officeCode = ? WHERE e.officeCode = ?";
            PreparedStatement ps2 = connection.prepareStatement(sql);

            ps2.setString(1, "100");
            ps2.setString(2, "5");

            ps2.executeUpdate();
            connection.commit();
            System.out.println("Empleados trasladados.");

        } catch (SQLException e) {
            System.out.println("error: " +e.getMessage());
            try{
                if (connection!=null){
                    System.out.println("BBDD en estado consistente.");
                    connection.rollback();
                }
            } catch (SQLException throwables){
                System.out.println("Error en el rollback");
                throwables.printStackTrace();
            }
        }
    }
}

