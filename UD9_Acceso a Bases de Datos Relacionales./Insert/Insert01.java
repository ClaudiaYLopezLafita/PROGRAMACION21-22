package Insert;

import java.sql.*;

public class Insert01 {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:336/classicmodels?user=root&password=root");
            String sql = "insert into productline values(?,?,?,null)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,"gato");
            statement.setString(2,"gata");
            statement.setString(3,"gatose");

            int resul = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
