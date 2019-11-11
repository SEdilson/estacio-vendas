/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetoav2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author edilson
 */
public class ConexaoDB {
    
    public static Connection conn;
    
    public ConexaoDB() {
        
    }
    
    public static Connection getConexaoDB() {
        
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            
            String host = "localhost";
            String db = "estacio_vendas";
            String url = "jdbc:mysql://" + host + ":3306/" + db;
            String user = "root";
            String senha = "mysql";
            
            conn = DriverManager.getConnection(url, user, senha);
            return conn;
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println("Não foi possível conectar");
            return null;
        }
    }
}
