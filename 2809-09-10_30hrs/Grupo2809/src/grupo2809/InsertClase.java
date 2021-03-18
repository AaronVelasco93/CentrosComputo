/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo2809;
import java.sql.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Aaron
 */
public class InsertClase {
    
     /**
         * Nombre de DB: fes_aragon
         * Tabla: alumno
         * campos: nombre_usuario, carrera
         * host: localhost - 127.0.0.1
         * puerto:3306
         * user:root
         * pass:123456
         * pass:"";
         */
    
    private Connection con;
    
    //CONEXION
    
    public InsertClase(){
        String host;
        String dbName;
        try {
            //cargar Driver
            Class.forName("com.mysql.jdbc.Driver");
            host = "jdbc:mysql://127.0.0.1:3306/";
            //miBBDD?serverTimezone=UTC
            dbName = "fes_aragon";
            
            con = DriverManager.getConnection(host+dbName,"root","123456");
            
            
            
        } catch (Exception e) {
            
            System.out.println("Problema de conexion"+e);
            e.printStackTrace();
        }
        
    }
    
    //insertar 
    
    public int insertarRegistro (String nombre_usuario, String carrera,String no_cuenta, String direccion, String telefono, String email, String password){
    String sql = "INSERT INTO alumno (nombre_usuario, carrera, no_cuenta, direccion, telefono, email, password) VALUES (?,?,?,?,?,?,?);";
    int res =0;
    
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
    
    //metodo main
    public static void main(String[] args) {
        
        InsertClase insertar = new InsertClase();
      
        int r = insertar.insertarRegistro("Ana","Enfermeria","12565","Rosales 5","55641854","ana@gmail.com","123456");
        
        if(r==1){
            System.out.println("ok listo");
        }else{
            System.out.println("Error al insertar o algo");
        }
        
    }
    
}
