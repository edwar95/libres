/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Consultas extends Conexion {

    public boolean autenticacion(String identificacion, String contrasena) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "SELECT * FROM `login` WHERE identificacion=? and pssw=?";
            pst=getConexion().prepareStatement(consulta);
            pst.setString(1, identificacion);
            pst.setString(2, contrasena);
            rs = pst.executeQuery();

            if (rs.absolute(1)) {
                return true;
            }

        } catch (Exception e) {
            System.err.println("error" + e);
        } finally {
            try {
                if (getConexion() != null) getConexion().close();
                if(pst!=null) pst.close();
                if(rs!=null)rs.close();
            } catch (Exception e) {
                 System.err.println("error" + e);
            }

        }

        return false;
    }
    
    public boolean ingresarCuenta(String nombre,String apellido,String cedula,String correo,String password) {
        PreparedStatement pst = null;
        int rs = 0;

        try {
            String consulta = "INSERT INTO cuenta (nombre, apellido, cedula, correo, password)VALUES (?, ?, ?,?,?)";
            pst=getConexion().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, cedula);
            pst.setString(4, correo);
            pst.setString(5, password);
            rs = pst.executeUpdate();

            if (rs==1) {
                return true;
            }

        } catch (Exception e) {
            System.err.println("error" + e);
        } finally {
            try {
                if (getConexion() != null) getConexion().close();
                if(pst!=null) pst.close();
                
            } catch (Exception e) {
                 System.err.println("error" + e);
            }

        }

        return false;
    }
    
    
    public static void main(String [] args){
        Consultas co= new Consultas();
        System.out.print(""+co.ingresarCuenta("david","david","1724720808","davidmoralesp1995@hotmail.com","david"));
        
        
        Consultas con= new Consultas();
        System.out.print(con.autenticacion("david", "david"));
    
    }
    
}
