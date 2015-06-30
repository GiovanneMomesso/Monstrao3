/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioDAO {
    private Connection connection;
    
    public UsuarioDAO () {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void insere(Usuario user) {
        String sql = "INSERT INTO usuario (senha, login, email, tipo) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getSenha());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, "user");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
