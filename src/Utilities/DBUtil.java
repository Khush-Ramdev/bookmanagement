package Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtil {
    public static Connection getConnection( )  {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignmentOne", "root", "khush");
            return conn;
        }
        catch (Exception e) {
            System.out.println("Connect to DB Failed");
            e.printStackTrace();
        }
        return conn;
    }
}
