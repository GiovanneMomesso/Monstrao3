/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoDAO {
    
    private Connection connection;

    public PedidoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void inserir(Pedido pedido) throws SQLException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        
        String sql = "INSERT INTO pedido (idCliente, status) VALUES (?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, pedido.getIdCliente());
        stmt.setString(2, "aberto");
        stmt.setDouble(3, pedido.getValor());
        //stmt.setDate(3, dateFormat.format(data));
        stmt.executeUpdate();
        stmt.close();        
    }
    
    public void alterar(Pedido pedido) throws SQLException{
        String sql = "UPDATE pedido SET status = finalizado WHERE idPedido = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(0, pedido.getIdPedido());
        stmt.executeUpdate();
        stmt.close();
    }
    
    public List<Pedido> listar() throws SQLException{
        String sql = "SELECT * FROM pedido WHERE status = aberto";
        List<Pedido> pedidos = new ArrayList<Pedido>();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Pedido ped = new Pedido();
            ped.setIdPedido(rs.getInt("idPedido"));
            ped.setIdCliente(rs.getInt("idCliente"));
            ped.setStatus(rs.getString("status"));
            pedidos.add(ped);
        }
        rs.close();
        stmt.close();
        return pedidos;
    }
}
