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
public abstract class Funcionario implements Autenticavel {
    //classe abstrata, voce nao consegue invocar o construtor, gerar um objeto
    
    //private, somente a classe pái vai ter acesso aos atributos. a classe filha vai ser referencia atraves do gets e sets pelo super
    private String nome;
    private String cpf;
    protected double salario;
    private int senha;
    
    //construtor, n precisaria ter, poderia fazer os gets e sets
    public Funcionario(String nome, String cpf, double salario){
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        //usa this porque faz referencia ao atributo da propria classe
    }

    //faz os gets e sets para encapsular
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
    
    @Override
    public boolean autenticar(int senha) {
        if (this.senha == senha) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void calcularBonus() {
        //nao precisa fazer nada aqui, pois vamos sobrescrever esse metodos nos filhos
    }
}
