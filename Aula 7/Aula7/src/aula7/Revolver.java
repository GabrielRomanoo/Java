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
public class Revolver extends Arma implements Disparavel{
    
    private int cartucho;
    
    public Revolver(int c){
        this.cartucho = c;
        this.destruicao = 100;
    }

    public int getCartucho() {
        return cartucho;
    }

    public void setCartucho(int cartucho) {
        this.cartucho = cartucho;
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
        this.cartucho = this.cartucho - 1;
        
    }

    @Override
    public void recarregar() {
       this.cartucho = this.cartucho + 6;
    }

    @Override
    public void golpear() {
       System.out.println("Pow! Dano: "+this.getDestruicao());
    }

    
    
    


   
    
    
}
