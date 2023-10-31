/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.*;
/**
 *
 * @author Asus
 */
public class connectDB {
    private static Connection conn = null;
    
    private static connectDB instance = new connectDB();
    
    public static connectDB getInstance() {
        return instance;
    }
    
    public static void connect() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databasename=BookStore";
        String user = "sa";
        String pass = "123456";
        
        conn = DriverManager.getConnection(url, user, pass);
    }
    
    public static void disconnect() {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static Connection getConnect() {
        return conn;
    }
}
