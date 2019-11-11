/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetoav2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author edilson
 */
public class ProdutoDAO {
    
    public void create(Produto produto) {
        
        Connection conn = ConexaoDB.getConexaoDB();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO produto(DESCRICAO, PRECO, CATEGORIA) VALUES(?,?,?)");
            stmt.setString(1, produto.getDescricao());
            stmt.setFloat(2, produto.getPreco());
            stmt.setString(3, produto.getCategoria());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex);
        }
    }
    
    public List<Produto> read() {
        Connection conn = ConexaoDB.getConexaoDB();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produto = new ArrayList<>();
        
        try {
           stmt = conn.prepareStatement("SELECT * FROM produto");
           stmt.setString(1, "");
           rs = stmt.executeQuery();
           
           while(rs.next()) {
            Produto prod = new Produto();
            prod.setId(rs.getInt("ID"));
            prod.setPreco(rs.getFloat("PRECO"));
            prod.setDescricao(rs.getString("DESCRICAO"));
            prod.setCategoria("CATEGORIA");
            
            produto.add(prod);
           }
        } catch(SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
}