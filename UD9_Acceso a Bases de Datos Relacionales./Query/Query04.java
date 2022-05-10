package Query;

import java.sql.*;
import java.util.Scanner;

public class Query04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el codigo de una ofician");
        String officeCod = sc.nextLine();

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:336/classicmodels?user=root&password=root");
            String sql = "SELECT *" +
                    "FROM employees  \n" +
                    "WHERE officeCode = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,officeCod);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                    String name = rs.getString("firstName");
                    String apellido = rs.getString("lastName");
                    System.out.println("-------------------------");
                    System.out.println("First Name: " + name);
                    System.out.println("Last Name: " + apellido);
                    System.out.println("-------------------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //Establezco un tiempo máximo de respuesta

    }
}
