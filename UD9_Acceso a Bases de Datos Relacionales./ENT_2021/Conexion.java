package ENT_2021;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection con=null;

    public static Connection getConnection() {

        try {
            if (con == null) {
                con = DriverManager.getConnection("jdbc:mysql://localhost:336/classicmodels?user=root&password=root");
                System.out.println("Connection Successful");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return (con);
    }

    public static void close(){
        try {
            if (con != null) con.close();
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
