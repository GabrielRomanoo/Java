/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula7;

/**
 *
 * @author CEITELABINFO
 */
public class LancaChama extends Arma implements Disparavel{
    
    private int gas;

    public LancaChama(int g) {
        this.gas = g;
        this.destruicao = 150;
    }
    
    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    @Override
    public double getDestruicao() {
        return destruicao;
    }

    @Override
    public void setDestruicao(double destruicao) {
        this.destruicao = destruicao;
    }

    @Override
    public void disparar() {
        this.gas = this.gas - 10;
    }

    @Override
    public void recarregar() {
        this.gas = this.gas + 100;
    }
    
    @Override
    public void golpear() {
       System.out.println("Pow! Dano: "+this.getDestruicao());
    }
}
