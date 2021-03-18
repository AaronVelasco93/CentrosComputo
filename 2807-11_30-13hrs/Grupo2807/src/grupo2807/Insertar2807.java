/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo2807;
import java.sql.*;
/**
 *
 * @author Aaron
 */
public class Insertar2807 {
     
      /**
         * Nombre de la DB:fes_aragon
         * campos: nombre_alumno , carrera
         * Tabla:alumno
         * Puerto:3306
         * Servidor:localhost -> 127.0.0.1
         * User:root
         * Pass:123456
         * 
         **/
    private Connection con;
    //CONEXION
    public Insertar2807(){
        String dbHost;
        String dbName;
        String dbUser;
        String dbPassword;
        
        try {
            //cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            dbHost= "jdbc:mysql://127.0.0.1:3306/";
            dbName= "fes_aragon";
            dbUser= "root";
            dbPassword="123456";
            con = DriverManager.getConnection(dbHost+dbName,dbUser,dbPassword);
           
        } catch (Exception e) {
            
            System.out.println("Problema con la conexion"+e);
            e.printStackTrace();
        }
    
    }
   
    //Metodo para insertar
    
    public int insertarRegistro(String nombre_usuario, String carrera, String no_cuenta, String direccion, String telefono, String email, String password ){
        //7 campos
        String sql = "INSERT INTO alumno (nombre_usuario, carrera, no_cuenta, direccion, telefono, email, password)VALUES(?,?,?,?,?,?,?);";
        int res=0;
        
        try {
            PreparedStatement myquery = con.prepareStatement(sql);
            
            myquery.setString(1, nombre_usuario);
            myquery.setString(2, carrera);
            myquery.setString(3, no_cuenta);
            myquery.setString(4, direccion);
            myquery.setString(5, telefono);
            myquery.setString(6, email);
            myquery.setString(7, password);
            res=myquery.executeUpdate();
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        return res;
    }
    
    //main
    
    public static void main(String[] args) {
        Insertar2807 insertar = new Insertar2807();
        
        int r = insertar.insertarRegistro("Kelly", "Pedagogia", "451289", "EDOMEX 15", "56251451", "kelly@gmail.com", "123548");
        
        if(r==1){
            System.out.println("se inserto de manera correcta");
        }else{
            System.out.println("Error");
        }
        
        
        
    }
    
    
}
