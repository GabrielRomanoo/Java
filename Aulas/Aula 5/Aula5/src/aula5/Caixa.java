/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula5;

/**
 *
 * @author CEITELABINFO
 */
public class Caixa extends Funcionario{
    
    public Caixa(String nome, String cpf, double salario) {
        super(nome,cpf,salario);
    }
    
    @Override
    public void calcularBonus() {
        this.salario = this.salario * 1.35;
    }
    
}
