/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula.pkg13;

/**
 *
 * @author CEITELABINFO
 */
public class Pessoa {
    
    private String nome;
    private String RG;

    public Pessoa(String nome, String RG) {
        this.nome = nome;
        this.RG = RG;
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }
    
    
    
}
