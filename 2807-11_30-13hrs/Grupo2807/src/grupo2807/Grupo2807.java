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
public class Grupo2807 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
        String host;
        String dbName;
        String dbUser;
        String dbPass;
        
        try {
            //1.- Cargar Driver
            //metodo estatico
            Class.forName("com.mysql.jdbc.Driver");
            
            
            //definir la URL
            host="jdbc:mysql://localhost:3306/";
            
            dbName="fes_aragon";
            dbUser="root";
            dbPass="123456";
            
            //3.- Establecer la conexion a la base de datos
           
            Connection db = DriverManager.getConnection(host+dbName,dbUser,dbPass);
            
            Statement st = db.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM alumno");
            
            if (rs.wasNull())
                    System.out.println("No hay NADA");
            
            while (rs.next()) 
                    System.out.println(rs.getString("nombre_alumno")+" "+rs.getString("carrera"));
                
         rs.close();
         st.close();
         db.close();//conexion
            
        } catch (Exception e) {
            System.out.println("Problema con la conexion"+e);
            
        }
        
        
        
        
        
    }
    
}
