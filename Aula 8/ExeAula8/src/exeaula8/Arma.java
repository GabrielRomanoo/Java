/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exeaula8;

/**
 *
 * @author ferauche
 */
public abstract class Arma implements Comparable<Arma> {
    
    protected double destruicao;

    public double getDestruicao() {
        return destruicao;
    }

    public void setDestruicao(double destruicao) {
        this.destruicao = destruicao;
    }

    @Override
    public int compareTo(Arma o) {
        return (int) (this.destruicao - o.getDestruicao());
    }
    
}
