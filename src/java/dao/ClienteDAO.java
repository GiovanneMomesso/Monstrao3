/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void insere(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, endereco, login, senha, email, tipo, news, cep, cpf) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getLogin());
            stmt.setString(4, cliente.getSenha());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, "user");
            stmt.setBoolean(7, cliente.isNews());
            stmt.setString(8, cliente.getCep());
            stmt.setString(9, cliente.getCpf());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Cliente cliente) {
        String sql = "UPDATE cliente SET nome=?, email=?, cpf=?, cep=?, endereco=?, news=? WHERE idCliente = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getCep());
            stmt.setString(5, cliente.getEndereco());
            stmt.setBoolean(6, cliente.isNews());
            stmt.setInt(7, cliente.getIdUsuario());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Cliente cliente) {
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getIdUsuario());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listar() throws SQLException {
        String sql = "SELECT * FROM cliente WHERE tipo LIKE 'user'";
        List<Cliente> cliente = new ArrayList();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Cliente cli = new Cliente();
            cli.setNome(rs.getString("nome"));
            cli.setIdUsuario(rs.getInt("idCliente"));
            cli.setEmail(rs.getString("email"));
            cli.setEndereco(rs.getString("endereco"));
            cli.setCep(rs.getString("cep"));
            cli.setCpf(rs.getString("cpf"));
            cli.setNews(rs.getBoolean("news"));
            cliente.add(cli);
        }
        return cliente;
    }

    public List<Cliente> listar_promo() throws SQLException {
        String sql = "SELECT * FROM cliente WHERE news=1 AND tipo LIKE 'user'";
        List<Cliente> cliente = new ArrayList();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Cliente cli = new Cliente();
            cli.setNome(rs.getString("nome"));
            cli.setIdUsuario(rs.getInt("idCliente"));
            cli.setEmail(rs.getString("email"));
            cli.setEndereco(rs.getString("endereco"));
            cli.setCep(rs.getString("cep"));
            cli.setCpf(rs.getString("cpf"));
            cli.setNews(rs.getBoolean("news"));
            cliente.add(cli);
        }
        return cliente;
    }

    public Cliente buscar_cliente(int idCli) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE idCliente=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idCli);
        ResultSet rs = stmt.executeQuery();
        Cliente cliente = new Cliente();
        while (rs.next()) {
            cliente.setNome(rs.getString("nome"));
            cliente.setIdUsuario(rs.getInt("idCliente"));
            cliente.setEmail(rs.getString("email"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setCep(rs.getString("cep"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setNews(rs.getBoolean("news"));
        }
        return cliente;
    }

    public Cliente login(String login, String senha) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE login=? and senha=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, login);
        stmt.setString(2, senha);
        ResultSet rs = stmt.executeQuery();
        if (rs == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        while (rs.next()) {
            cliente.setNome(rs.getString("nome"));
            cliente.setLogin(rs.getString("login"));
            cliente.setIdUsuario(rs.getInt("idCliente"));
            cliente.setEmail(rs.getString("email"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setCep(rs.getString("cep"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setSenha(rs.getString("senha"));
            cliente.setTipo(rs.getString("tipo"));
            //cliente.setNews(rs.getBoolean("news"));  
        }
        return cliente;
    }

    public List<Cliente> procurar(String str) throws SQLException {
        String sql = "SELECT nome, idCliente, email FROM cliente WHERE nome LIKE ? AND tipo LIKE 'user'";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, "%" + str + "%");
        List<Cliente> cliente = new ArrayList();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Cliente cli = new Cliente();
            cli.setNome(rs.getString("nome"));
            cli.setIdUsuario(rs.getInt("idCliente"));
            cli.setEmail(rs.getString("email"));
            cliente.add(cli);
        }
        stmt.close();
        return cliente;
    }
    
    public boolean verificaLogin(String login) throws SQLException {
        String sql = "SELECT login FROM cliente";
        boolean ok = true;
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            if(rs.getString("login").equals(login)) {
                ok = false;
            } else {
                ok = true;
            }
        } 
        rs.close();
        return ok;
    }            
}
