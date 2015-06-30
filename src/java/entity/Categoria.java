/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

public class Categoria {
    private String nome;
    private int idCategoria;


    public Categoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
        
    public int getIdCategoria() {
        return idCategoria;
    }
    
}

