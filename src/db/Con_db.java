package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Con_db {
    public static Connection getConnnection() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/employee";
            String username = "root";
            String password = "Nandhu07";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("DB CONNECTED");

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }


}
