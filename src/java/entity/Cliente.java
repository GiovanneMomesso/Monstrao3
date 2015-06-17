/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import dao.CarrinhoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class Cliente extends Usuario implements Serializable{
    private String endereco;
    private String cpf;
    private String cep;
    private int pedido;     
    //essa variável é para saber se o cliente tem algum pedido aberto//
    private boolean news;
    private List<Produto> produtos;
    private double valor_pedido;

    public Cliente() {
    }
 
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isNews() {
        return news;
    }

    public void setNews(boolean news) {
        this.news = news;
    }
    
     public void setPedido() throws SQLException {
        CarrinhoDAO car = new CarrinhoDAO();        
        this.pedido = car.verificar(idUsuario);       
    }
     
     public int getPedido(){
         return this.pedido;
     }
     
     public void setProdutos() throws SQLException{
         CarrinhoDAO car = new CarrinhoDAO();        
         ArrayList<Integer> idsProdutos = new ArrayList<Integer>();
         List<Produto> produtos2 = new ArrayList();            
         ArrayList<Integer> numQuant = new ArrayList<Integer>();            
         idsProdutos.addAll(car.listarIdProd(this.getPedido()));
         numQuant.addAll(car.listarQuantidade(this.getPedido()));
         produtos2.addAll(car.listarcar(idsProdutos, numQuant));
         this.produtos = produtos2;
         
     }
     
 
     
     public List<Produto> getProdutos(){
         return this.produtos;
     }        

    /**
     * @return the valor_pedido
     */
    public double getValor_pedido() {
        return valor_pedido;
    }

    /**
     * @param valor_pedido the valor_pedido to set
     */
    public void setValor_pedido(double valor_pedido) {
        this.valor_pedido = valor_pedido;
    }

    
    
}
