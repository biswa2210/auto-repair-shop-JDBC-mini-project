package com.Carrepair;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    static Connection con;
    public static Connection CreateConnection() {
        try {
            //LOAD THE DRIVER
            Class.forName("com.mysql.jdbc.Driver");
            //CREATE THE CONNECTION
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/garage_records","root","BISWA_LOVES_CODING");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
