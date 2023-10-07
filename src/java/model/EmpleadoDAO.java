/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jhon
 */
public class EmpleadoDAO {
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Empleado validar(String user, String dni){
        //Instanciar la clase Empleado
        Empleado em = new Empleado();
        String sql = "select * from empleado where User=? and Dni=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            //Asignar los valores que vienen como aprametro dentro de nuestra
            //consulta sql
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while( rs.next() ){
                //em = Entidad Empleado
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
        } catch (Exception e) {
        }
        return em;
    }
}
