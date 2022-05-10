package Query;

import java.sql.*;

public class Query01 {
    public static void main(String[] args) {
        //Creamos el objeto conexión
        Connection connection = null;

        try {
            //Creo la conexión a la base de datos
            // La paso el nombre de la base de datos classimodels
            // El usuario de la base de datos user=usuario
            // La contraseña password=usuario
            connection = DriverManager.getConnection("jdbc:mysql://localhost:336/classicmodels?user=root&password=root");

            //Creo el objeto para ejecutar la sentencias SQL
            Statement statement = connection.createStatement();

            //Establezco un tiempo máximo de respuesta
            statement.setQueryTimeout(30);

            //Ejecuta una consulta de sencilla de búsqueda
            //El resultado se almacena en el ResultSet (conjunto de resultados)
            ResultSet rs = statement.executeQuery("select * from customers");

            //Recorremos el conjunto de resultados
            while (rs.next()) {
                //Obtenemos un campo cadena
                System.out.println("CustomerName :" + rs.getString("customerName"));
                //Obtenemos un campo de tipo entero
                System.out.println("CustomerNumber :" + rs.getInt("customerNumber"));
                //Obtenemos un campo por posición
                System.out.println("Tercer campo :" + rs.getString(3));
                System.out.println("-----------------");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
