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
public class PF extends Pessoa {
    
    private String cpf;

    public PF(String nome, String endereco, double rendimentos ,String cpf) {
        super(nome, endereco, rendimentos);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public double calcularImposto() {
        if (this.getRendimentos() < 3000.00) {
            return this.getRendimentos() * 0.11;
        }
        else {
            return this.getRendimentos() * 0.275;
        }
    }
    
    
    
}
