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
public class PJ extends Pessoa{
    
    private String cnpj;
    
    public PJ(String nome, String endereco, double rendimentos, String cnpj) {
        super(nome,endereco,rendimentos);
        //super usa o construtor de Pessoa;
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public double calcularImposto() {
        return (0.18 * this.getRendimentos());
    }
    
}
