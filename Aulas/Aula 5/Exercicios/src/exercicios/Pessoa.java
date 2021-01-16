/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

/**
 *
 * @author CEITELABINFO
 */
public abstract class Pessoa {
     //classe abstrata, voce nao consegue invocar o construtor, gerar um objeto
    
    private String nome;
    private String endereco;
    private double rendimentos;

    public Pessoa(String nome, String endereco, double rendimentos) {
        this.nome = nome;
        this.endereco = endereco;
        this.rendimentos = rendimentos;
        
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getRendimentos() {
        return rendimentos;
    }

    public void setRendimentos(double rendimentos) {
        this.rendimentos = rendimentos;
    }
    
    public double calcularImposto() {
        return 0.0;
    }
    
}
