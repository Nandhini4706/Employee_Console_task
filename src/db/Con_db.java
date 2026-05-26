package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Con_db {
    public static Connection getConnection() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/employees";
            String username = "root";
            String password = "Nandhu07";
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Database Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
