/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class CategoriaDAO {

    private Connection connection;

    public CategoriaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void insere(Categoria categoria) {
        String sql = "INSERT INTO `categoria`(`nome`) VALUES (?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Categoria categoria) {
        String sql = "UPDATE categoria SET nome=? WHERE idCategoria = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getIdCategoria());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void excluir(Categoria categoria) {
        String sql = "DELETE FROM categoria WHERE idCategoria = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, categoria.getIdCategoria());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Categoria> listar() throws SQLException {
        String sql = "SELECT * FROM categoria";
        List<Categoria> categoria = new ArrayList();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Categoria cat = new Categoria();
            cat.setNome(rs.getString("nome"));
            cat.setIdCategoria(rs.getInt("idCategoria"));
            categoria.add(cat);
        }
        return categoria;
    }

    public Categoria buscaCat(int idCat) throws SQLException {
        String sql = "SELECT * FROM categoria WHERE idCategoria=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idCat);
        ResultSet rs = stmt.executeQuery();
        Categoria categoria = new Categoria();
        while (rs.next()) {
            categoria.setNome(rs.getString("nome"));
            categoria.setIdCategoria(rs.getInt("idCategoria"));
        }
        return categoria;
    }

    public List<Categoria> procurar(String str) throws SQLException {
        String sql = "SELECT nome, idCategoria FROM categoria WHERE nome LIKE ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, "%" + str + "%");
        List<Categoria> categoria = new ArrayList();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Categoria cat = new Categoria();
            cat.setNome(rs.getString("nome"));
            cat.setIdCategoria(rs.getInt("idCategoria"));
            categoria.add(cat);
        }
        stmt.close();
        return categoria;
    }
    
    public boolean categoriaIgual(String categoria) throws SQLException {
        String sql = "SELECT nome FROM categoria";
        boolean ok = true;
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            String cat = rs.getString("nome");
            if (categoria.equals(cat)) {
                ok = false;
            } else {
                ok = true;
            }
        }
        rs.close();
        stmt.close();
        return ok;
    }
}
