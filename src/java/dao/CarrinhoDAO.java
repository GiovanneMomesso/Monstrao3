package dao;

import entity.Pedido;
import entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Rafael Kozar
 */
public class CarrinhoDAO {

    private Connection connection;

    public CarrinhoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void incluirProduto(int idPedido, int idProduto) throws SQLException {
        String sql1 = "INSERT INTO itenspedido (idPedido, idProduto, quantidade) VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql1);
        stmt.setInt(1, idPedido);
        stmt.setInt(2, idProduto);
        stmt.setInt(3, 1);
        stmt.executeUpdate();
        stmt.close();
    }

    public void incluirPedido(int idCliente) throws SQLException {
        String sql1 = "INSERT INTO pedido (idCliente, status) VALUES (?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql1);
        stmt.setInt(1, idCliente);
        stmt.setString(2, "aberto");
        stmt.executeUpdate();
        stmt.close();
    }

    public void deletarItemPedido(int idPedido, int idProduto) throws SQLException {
        String sql = "DELETE FROM itenspedido WHERE idPedido = ? and idProduto = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idPedido);
        stmt.setInt(2, idProduto);
        stmt.executeUpdate();
        stmt.close();
    }

    public void finalizarPeido(int idPedido) {
        String sql = "UPDATE pedido SET status=?, valor=?, data=? WHERE idPedido = ?";
    }

    public void finalizarPedido(Pedido pedido) throws SQLException {
        String sql = "UPDATE pedido SET status=?, valor=? WHERE idPedido = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, "finalizado");
        stmt.setDouble(2, pedido.getValor());
        //stmt.setDate(3, pedido.getData_pedido());
        stmt.setInt(3, pedido.getIdPedido());
        stmt.executeUpdate();
        stmt.close();
    }

    public void setarQuantidade(Pedido pedido, List<Produto> produtos) throws SQLException {
        int tamanho = produtos.size();
        for (int i = 0; i < tamanho; i++) {
            String sql = "UPDATE itenspedido SET quantidade=? WHERE idPedido = ? and idProduto = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            Produto prod = new Produto();
            prod = produtos.get(i);
            stmt.setInt(1, prod.getQuantidade());
            stmt.setInt(2, pedido.getIdPedido());
            stmt.setInt(3, prod.getIdProduto());
            stmt.executeUpdate();
            stmt.close();            
        }

    }
    public void setarValor(Pedido pedido) throws SQLException {        
            String sql = "UPDATE pedido SET valor=? WHERE idPedido = ? and idCliente = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setDouble(1, pedido.getValor());
            stmt.setInt(2, pedido.getIdPedido());
            stmt.setInt(3, pedido.getIdCliente());
            stmt.executeUpdate();
            stmt.close();            
        

    }

    public int getIdPedido() {
        return 0;
    }

    public int verificar(int idCliente) throws SQLException {
        int idped = 0;
        String sql = "SELECT idPedido FROM pedido WHERE idCliente = ? AND status = ?"; //and status = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idCliente);
        stmt.setString(2, "aberto");
        ResultSet rs = stmt.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                idped = rs.getInt("idPedido");
            }
            return idped;
        } else {
            //           stmt.close();
            return 0;
        }
        //return 7;
    }

    /* public List<Produto> listarcar(int[] idsProdutos) throws SQLException {        
     int tamanho = idsProdutos.length;
     List<Produto> produtos = new ArrayList();
     for (int k = 0; k < tamanho; k++) {
     String sql = "SELECT nome, preco FROM produto WHRE idProduto = ?";
     PreparedStatement stmt = connection.prepareStatement(sql);
     stmt.setInt(1, idsProdutos[k]);         
     ResultSet rs = stmt.executeQuery();
     if (rs != null) {
     while (rs.next()) {
     Produto prod = new Produto();
     prod.setNome(rs.getString("nome"));                    
     prod.setValor(rs.getDouble("preco"));                    
     produtos.add(prod);
     }
     }
     }
     return produtos; 
     }*/
    public ArrayList<Integer> listarIdProd(int idPedido) throws SQLException {
        String sql = "SELECT idProduto FROM itenspedido WHERE idPedido = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        int prod = 0;
        stmt.setInt(1, idPedido);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Integer> idsProdutos = new ArrayList<Integer>();
        int[] ids = new int[10];
        int i = 0;
//        System.out.println("aqui1");
        if (rs != null) {
            while (rs.next()) {
                //int num = 0;
                prod = rs.getInt("idProduto");
                //i++;
                idsProdutos.add(prod);
                // idsProdutos.add(quant);
            }
            return idsProdutos;
        } else {
            return null;
        }

    }

    public ArrayList<Integer> listarQuantidade(int idPedido) throws SQLException {
        String sql = "SELECT quantidade FROM itenspedido WHERE idPedido = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        int prod = 0;
        stmt.setInt(1, idPedido);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Integer> quantidade = new ArrayList<Integer>();
        int[] ids = new int[10];
        int i = 0;
//        System.out.println("aqui1");
        if (rs != null) {
            while (rs.next()) {
                //int num = 0;
                prod = rs.getInt("quantidade");
                //i++;
                quantidade.add(prod);
                // idsProdutos.add(quant);
            }
            return quantidade;
        } else {
            return null;
        }

    }

    public List<Produto> listarcar(ArrayList<Integer> idsProdutos, ArrayList<Integer> quantidade) throws SQLException {
        int tamanho = idsProdutos.size();
        List<Produto> produtos = new ArrayList();
        for (int k = 0; k < tamanho; k++) {
            String sql = "SELECT nome, preco, idProduto FROM produto WHERE idProduto = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idsProdutos.get(k));
            ResultSet rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Produto prod = new Produto();
                    prod.setNome(rs.getString("nome"));
                    prod.setValor(rs.getDouble("preco"));
                    prod.setIdProduto(idsProdutos.get(k));
                    prod.setQuantidade(quantidade.get(k));
                    produtos.add(prod);
                }
            }

        }
        return produtos;
    }

}
