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
public class VentaDAO {
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public String GenerarSerie(){
        String numeroSerie = "";
        String sql = "select max(NumeroSerie) from ventas";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while( rs.next() ){
                numeroSerie = rs.getString(1);
                
            }
        } catch (Exception e){
            
        }
        return numeroSerie;
    }
}
