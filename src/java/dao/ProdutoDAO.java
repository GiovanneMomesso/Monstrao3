package dao;

import entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Kozar
 */
public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void insere(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco, desc_bas, desc_det, imagem, promo, idCategoria) values(?,?,?,?,?,?,?) ";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getValor());
            stmt.setString(3, produto.getDescricaoBasica());
            stmt.setString(4, produto.getDescricaoDetal());
            stmt.setString(5, produto.getImg());
            stmt.setBoolean(6, produto.isPromocional());
            stmt.setInt(7, produto.getIdCategoria());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Produto> listar() throws SQLException {
        String sql = "SELECT * FROM produto";
        List<Produto> produto = new ArrayList();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Produto prod = new Produto();
            prod.setNome(rs.getString("nome"));
            prod.setIdCategoria(rs.getInt("idCategoria"));
            prod.setCategoria(buscaCat(prod.getIdCategoria()));
            prod.setValor(rs.getDouble("preco"));
            prod.setDescricaoBasica(rs.getString("desc_bas"));
            prod.setDescricaoDetal(rs.getString("desc_det"));
            prod.setImg(rs.getString("imagem"));
            prod.setIdProduto(rs.getInt("idProduto"));
            produto.add(prod);
        }
        return produto;
    }
    
        public List<Produto> listarpromo() throws SQLException {
        String sql = "SELECT * FROM produto WHERE promo = 1";
        List<Produto> produto = new ArrayList();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Produto prod = new Produto();
            prod.setNome(rs.getString("nome"));
            prod.setIdCategoria(rs.getInt("idCategoria"));
            prod.setCategoria(buscaCat(prod.getIdCategoria()));
            prod.setValor(rs.getDouble("preco"));
            prod.setDescricaoBasica(rs.getString("desc_bas"));
            prod.setDescricaoDetal(rs.getString("desc_det"));
            prod.setImg(rs.getString("imagem"));
            prod.setIdProduto(rs.getInt("idProduto"));
            produto.add(prod);
        }
        return produto;
    }

    public String buscaCat(int idCat) throws SQLException {
        String sql = "SELECT nome FROM categoria WHERE idCategoria=?";
        String categoria = null;
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idCat);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            categoria = rs.getString("nome");
        }
        stmt.close();
        return categoria;
    }

    public Produto buscaProd(int idProd) throws SQLException {
        String sql = "SELECT * FROM produto WHERE idProduto=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, idProd);
        ResultSet rs = stmt.executeQuery();
        Produto prod = new Produto();
        while (rs.next()) {
            prod.setNome(rs.getString("nome"));
            prod.setIdCategoria(rs.getInt("idCategoria"));
            prod.setCategoria(buscaCat(prod.getIdCategoria()));
            prod.setValor(rs.getDouble("preco"));
            prod.setDescricaoBasica(rs.getString("desc_bas"));
            prod.setDescricaoDetal(rs.getString("desc_det"));
            prod.setImg(rs.getString("imagem"));
            prod.setIdProduto(rs.getInt("idProduto"));
            prod.setPromocional(rs.getBoolean("promo"));
        }
        return prod;
    }

    public void update(Produto produto) throws SQLException {
        String sql = "UPDATE PRODUTO SET nome=?, idCategoria=?,  preco=?, desc_bas=?, desc_det=?, imagem=?, promo=? WHERE idProduto=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setInt(2, produto.getIdCategoria());
        stmt.setDouble(3, produto.getValor());        
        stmt.setString(4, produto.getDescricaoBasica());
        stmt.setString(5, produto.getDescricaoDetal());
        stmt.setString(6, produto.getImg());
        stmt.setBoolean(7, produto.isPromocional());        
        stmt.setInt(8, produto.getIdProduto());
        stmt.executeUpdate();
        stmt.close();
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM produto WHERE idProduto = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }
    
        public void excluir_cat(int id) throws SQLException {
        String sql = "DELETE FROM produto WHERE idCategoria = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }
    
    public List<Produto> procurar(String str) throws SQLException{
        String sql = "SELECT nome, preco, idCategoria, idProduto, imagem FROM produto WHERE nome LIKE ?"
               + "UNION SELECT nome, preco, idCategoria, idProduto, imagem FROM produto WHERE desc_bas  LIKE ?"
               + "UNION SELECT nome, preco, idCategoria, idProduto, imagem FROM produto WHERE desc_det  LIKE ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, "%"+str+"%");        
        stmt.setString(2, "%"+str+"%");
        stmt.setString(3, "%"+str+"%");
        List<Produto> produto = new ArrayList();
        ResultSet rs = stmt.executeQuery();        
        while (rs.next()) {
            Produto prod = new Produto();
            prod.setNome(rs.getString("nome"));
            prod.setValor(rs.getDouble("preco"));
            prod.setIdCategoria(rs.getInt("idCategoria"));
            prod.setCategoria(buscaCat(prod.getIdCategoria()));
            prod.setIdProduto(rs.getInt("idProduto"));
            prod.setImg(rs.getString("imagem"));
            produto.add(prod);
//            prod.setIdCategoria(rs.getInt("idCategoria"));
//            //prod.setCategoria(buscaCat(prod.getIdCategoria()));
//            prod.setValor(rs.getDouble("preco"));
//            prod.setDescricaoBasica(rs.getString("desc_bas"));
//            prod.setDescricaoDetal(rs.getString("desc_det"));
//            prod.setIdProduto(rs.getInt("idProduto"));
//            produto.add(prod);
        }
        stmt.close();
        return produto;
    }
    
    public boolean produtoIgual(String prod, int idCat) throws SQLException {
        String sql = "SELECT nome, idCategoria FROM produto";
        boolean ok = true;
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            if(rs.getString("nome").equals(prod) && (rs.getInt("idCategoria") == idCat)) {
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
