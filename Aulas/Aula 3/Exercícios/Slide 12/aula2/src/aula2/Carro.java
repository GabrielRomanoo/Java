/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula2;

/**
 *
 * @author CEITELABINFO
 */
public class Carro {
    
    //atributos:
    float tanque;
    float odometro;
    private float consumoMedio;
    float kmRodado;
    boolean trocaPneu;
    
    public Carro() { } //construtor padrao
    
    //construtor
    public Carro(float consumo) {
        this.consumoMedio = consumo;
        this.tanque = 40;
        this.odometro = 1000;
        this.kmRodado = 0;
        this.trocaPneu = false;
        //this é pra deixar explicito no codigo que consumoMedio nao é uma referencia desse escopo, desse construtor
    }
    
    //a diferenca desse pro de cima, é que esse voce manda tudo de uma vez, ai ele chama esse, se vc passase so um, ia chamar o construtor de cima
    public Carro(float tanque, float odometro, float consumedio, float kmRodado) {
        this.tanque = tanque;
        this.odometro = odometro;
        this.consumoMedio = consumedio;
        this.kmRodado = kmRodado;
        this.trocaPneu = false;
    }
    
    //metodo
    public void setarVelocidade(float vm, float tempo) {
        float distancia = vm * tempo;
        float litros = distancia / this.consumoMedio;
        this.odometro += distancia;
        this.tanque -= litros;
        this.kmRodado += distancia;
         if (this.kmRodado >= 30000) {
            this.trocaPneu = true;
        }
    }
    
    //metodo
    public boolean isValidTrocarPneu() {
        return this.trocaPneu;
    }

    public float getConsumoMedio() {
        return consumoMedio;
    }

    public void setConsumoMedio(float consumoMedio) {
        this.consumoMedio = consumoMedio;
    }
    
    
}

