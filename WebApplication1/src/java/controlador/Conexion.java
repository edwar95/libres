/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class Conexion {
    
    private String USERNAME ="root";
    private String password="";
    private String host="localhost";
    private String port="3306";
    private String database="prueba";
    private String classname="com.mysql.jdbc.Driver";
    private String URL="jdbc:mysql://"+host+":"+port+"/"+database;
    private Connection con;
    
    public Conexion() {
        try{
           Class.forName(classname);
           con = DriverManager.getConnection(URL, USERNAME, password);
        }catch(ClassNotFoundException e){
            System.err.println("error"+e);
        }catch(SQLException e){
            System.err.println("error"+e);
        }
    }
    
    public Connection getConexion(){
     return con;   
    }
    
    public static void main(String [] args){
        Conexion con =new Conexion();
    }
    
}
