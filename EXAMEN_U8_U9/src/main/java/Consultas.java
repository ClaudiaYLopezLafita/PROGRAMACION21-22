import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Consultas {
    public static void main(String[] args) {

        CategoriaMasVendida();
        System.out.println();
        System.out.println(getProductLines());
    }

    public static List<ProductLine> getProductLines(){

        Connection connection = ConexionBD.getConnection();
        List list = new ArrayList();

        String sql = "SELECT p.*\n" +
                "FROM productlines p;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                ProductLine pl = new ProductLine();

                String name = rs.getString(1);
                String textD = rs.getString(2);
                String htmlD = rs.getString(3);
                String image = rs.getString(4);

                pl.setName(name);
                pl.setTextDescription(textD);
                pl.setDescription(htmlD);
                pl.setImage(image);

                list.add(pl);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public static void CategoriaMasVendida(){
        Connection connection = ConexionBD.getConnection();

        String sql = "SELECT p.productLine, SUM(o.quantityOrdered) \n" +
                "FROM productlines p INNER JOIN products p2 \n" +
                "ON p.productLine  = p2.productLine \n" +
                "INNER JOIN orderdetails o \n" +
                "ON p2.productCode = o.productCode\n" +
                "GROUP BY p.productLine \n" +
                "ORDER BY SUM(o.quantityOrdered) DESC\n" +
                "LIMIT 1;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            rs.next();

            System.out.println("La categoría más vendida es: ");
            System.out.println(rs.getString(1)+" con "+rs.getInt(2)+" unidades");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
