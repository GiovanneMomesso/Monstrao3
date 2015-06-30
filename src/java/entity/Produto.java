/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

public class Produto {
    public String nome;
    private String categoria;
    private String descricaoBasica;
    private String descricaoDetal;
    public double valor;
    private int idCategoria;
    private boolean promocional;
    private int idProduto;
    private String img;
    private int quantidade;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the descricaoBasica
     */
    public String getDescricaoBasica() {
        return descricaoBasica;
    }

    /**
     * @param descricaoBasica the descricaoBasica to set
     */
    public void setDescricaoBasica(String descricaoBasica) {
        this.descricaoBasica = descricaoBasica;
    }

    /**
     * @return the descricaoDetal
     */
    public String getDescricaoDetal() {
        return descricaoDetal;
    }

    /**
     * @param descricaoDetal the descricaoDetal to set
     */
    public void setDescricaoDetal(String descricaoDetal) {
        this.descricaoDetal = descricaoDetal;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }
    
    public int getIdCategoria(){
        return idCategoria;
    }
    
    public void setIdCategoria(int idCategoria){
        this.idCategoria = idCategoria;
    }
    
     public boolean isPromocional(){
        return promocional;
    }
    
    public void setPromocional(boolean promocional){
        this.promocional = promocional;
    }
    
    public int getIdProduto(){
        return idProduto;
    }
    
    public void setIdProduto(int id){
        this.idProduto = id;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setQuantidade(int quant){
        this.quantidade = quant;
    }
}
