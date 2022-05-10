package Query;

import java.sql.*;
import java.util.Scanner;

public class Query03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Creamos el objeto conexión
        Connection connection = null;

        try {
            //Creo la conexión a la base de datos
            // La paso el nombre de la base de datos classimodels
            // El usuario de la base de datos user=usuario
            // La contraseña password=usuario

            System.out.println("Indica el codigo de un cliente");
            int numCliente = sc.nextInt();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:336/classicmodels?user=root&password=root");

            //Creo el objeto para ejecutar la sentencias SQL
            Statement statement = connection.createStatement();

            //Establezco un tiempo máximo de respuesta
            statement.setQueryTimeout(30);

            //Ejecuta una consulta de sencilla de búsqueda
            //El resultado se almacena en el ResultSet (conjunto de resultados)
            ResultSet rs = statement.executeQuery("select sum(amount) from payments where customerNumber="+numCliente);
            rs.next();
            System.out.println("Total Suma Cliente:" + rs.getString(1));

        } catch (SQLException e) {
//            System.out.println(e.getMessage());
        } catch (Exception e) {
//            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
//                System.out.println(e.getMessage());
            }
        }
    }
}
