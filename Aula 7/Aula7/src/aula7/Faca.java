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
public class Faca extends Arma {
    
    private int lamina;

    public Faca(int lamina) {
        this.lamina = lamina;
        this.destruicao = 20;
    }
    
    public int getLamina() {
        return lamina;
    }

    public void setLamina(int lamina) {
        this.lamina = lamina;
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
    public void golpear(){
        System.out.println("Facada! Dano: "+this.getDestruicao());
        this.lamina = this.lamina - 1;
    }
    
    
    
}
