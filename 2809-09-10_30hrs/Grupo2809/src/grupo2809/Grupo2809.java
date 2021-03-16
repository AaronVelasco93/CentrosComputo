/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo2809;
import java.sql.*;

/**
 *
 * @author Aaron
 */
public class Grupo2809 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /**
         * Nombre de DB: fes_aragon
         * Tabla: alumno
         * campos: nombre_alumno, carrera
         * host: localhost - 127.0.0.1
         * puerto:3306
         * user:root
         * pass:123456
         */
        String host;
        String dbName;
     
        
        try {
            // 1.- cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Definir la url
            host="jdbc:mysql://localhost:3306/";
            //nombre de la db
            dbName="fes_aragon";
            
            //3.- Establecemos una conexion
            
            Connection db = DriverManager.getConnection(host + dbName,"root", "123456");
            
            Statement st = db.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM alumno");
            
            if (rs.wasNull()) 
                System.out.println("NADA \n");
            while (rs.next())
                System.out.println(rs.getString("nombre_alumno")+" "+rs.getString("CARRERA")+"");
            
            rs.close();
            st.close();
            db.close();
            
            
        } catch (Exception e) {
            
            System.out.println("problema con la conexion"+e);
            
        }
        
        
    }
    
}
