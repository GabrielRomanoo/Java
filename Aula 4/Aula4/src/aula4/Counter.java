/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4;

/**
 *
 * @author CEITELABINFO
 */
public class Counter {
    //a classe Counter esta emcapsulada, pq o atributo count esta private
    
    
    //private int count = 0;
    private static int count = 0;
    
    public Counter() {
        this.count++;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public void somar1() {
        this.count++;
    }
    
    public void contar2em2() {
        this.count+=2;
    }
    
    public static float divCount() {
        return count/2;
        //nao usa o this pq o metodo é static
    }
}
