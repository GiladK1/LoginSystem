package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class dataBase {


        public static Connection getConnection() throws Exception {
            try {
                String driver = "com.mysql.cj.jdbc.Driver";
                String url = "***********";
                String username = "*********";
                String password = "********";
                Class.forName(driver);
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("Connected");
                return conn;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

