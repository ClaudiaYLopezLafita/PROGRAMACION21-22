import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transacciones {
    public static void main(String[] args) {

        insertarPedido();

    }

    public static void insertarPedido(){
        Connection connection = ConexionBD.getConnection();

        try {
            connection.setAutoCommit(false);

            // INSERTAR EL NUEVO PRODUCTO
            String sql = "INSERT INTO orders VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, 9000);
            ps.setString(2, "2022-01-18");
            ps.setString(3, "2022-02-18");
            ps.setString(4, "2022-03-18");
            ps.setString(5, "Shipped");
            ps.setString(6, "El cliente está en EXAMEN");
            ps.setInt(7, 103);

            ps.executeUpdate();

            /// INSERTAR LOS 2 PRODUCTOS EN ORDERDETAILS
            String sql2 = "INSERT INTO orderdetails VALUES (?,?,?,?,?)";
            PreparedStatement ps2 = connection.prepareStatement(sql2);

            ps2.setInt(1, 9000);
            ps2.setString(2, "S10_1678");
            ps2.setInt(3, 10);
            ps2.setDouble(4, 12.6);
            ps2.setInt(5, 3);

            ps2.executeUpdate();

            String sql3 = "INSERT INTO orderdetails VALUES (?,?,?,?,?)";
            PreparedStatement ps3 = connection.prepareStatement(sql3);

            ps2.setInt(1, 9000);
            ps2.setString(2, "S12_4473");
            ps2.setInt(3, 2);
            ps2.setDouble(4, 122.6);
            ps2.setInt(5, 7);

            ps2.executeUpdate();
            connection.commit();
            System.out.println("Se han ingresado los datos correctamente");

        } catch (SQLException e) {
            System.out.println("error: "+e.getMessage());
            try {
                if (connection!=null) {
                    connection.rollback();
                    System.out.println("No se modifico la base de datos");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
