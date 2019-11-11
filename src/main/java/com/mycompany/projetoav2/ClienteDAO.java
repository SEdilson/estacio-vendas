/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetoav2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author edilson
 */
public class ClienteDAO {
    public void create(Cliente cliente) {
        
        Connection conn = ConexaoDB.getConexaoDB();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO cliente(NOME, CPF, DATANASC) VALUES(?,?,?)");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getDataNasc());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        }
    }
}
