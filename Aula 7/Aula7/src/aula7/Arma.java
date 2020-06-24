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
public abstract class Arma  {
    
    protected double destruicao;

    public double getDestruicao() {
        return destruicao;
    }

    public void setDestruicao(double destruicao) {
        this.destruicao = destruicao;
    }
    
    public abstract void golpear();
    
}
