/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Jkm
 */
public class Persistencia {
    private static Connection conn = null;
    
    private Persistencia(){
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/syspet", "root", "");
            
        }catch(ClassNotFoundException e){
            System.out.println("Não foi possível encontrar o Driver especificado " + e);
        }catch(SQLException ex){
            System.out.println("Não foi possível conectar ao banco de dados " + ex);
        }
    }
    
    public static Connection conexao(){
        if(conn == null)
            new Persistencia();
        return conn;
    }
}
