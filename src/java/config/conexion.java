/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jhon
 */
public class conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3307/bd_ventas";
    String user = "root";
    String password = "";
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Error al conectar con la Base de Datos");
        }
        return con;
    }
}
