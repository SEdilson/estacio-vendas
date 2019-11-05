/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetoav2;

import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author edilson
 */
public class ConexaoDB {
    
    public static Connection conn = null;
    
    public ConexaoDB() {
        
    }
    
    public static void getConexaoDB() {
        
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            
            String host = "localhost";
            String db = "estacio_vendas";
            String url = "jdbc:mysql://" + host + ":3306/" + db;
            String user = "root";
            String senha = "mysql";
            
            conn = DriverManager.getConnection(url, user, senha);
            System.out.print("Conectado com sucesso");
        } catch(ClassNotFoundException ex) {
            System.out.println("Driver não encontrado");
        } catch(SQLException ex) {
            System.out.println("Não foi possível conectar ao banco de dados.");
        }
    }
}
