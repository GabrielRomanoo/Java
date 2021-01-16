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
public class Gerente extends Funcionario{
    
    private int funcionarios;
    
    //construtor da classe gerente
    public Gerente(String nome, String cpf, double salario, int funcionarios){
        super(nome,cpf,salario);
        //super faz referencia a classe pai, podendo usar os atributos quandon forem privados
        //quando for protected, nao precisa do super
        this.funcionarios = funcionarios;
    }
    
    public void cancelarOperacao(){
        System.out.println("Operacao Cancelada!");
    }

    public int getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(int funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    //esse @ é uma palavra reservada que deixa claro pro compilador que o metodo abaixo foi reescrito, sobrescrevido. tambem facilita pra quem esta lendo
    @Override
    public void calcularBonus() {
        //quando o atributo é protected, faço o que ta abaixo
        this.salario = this.salario * 1.35;
        /* quando salario nao é protected, e sim privado
        double salario = this.getSalario();
        salario = salario * 1.35;
        this.setSalario(salario);
        */
    }
}
