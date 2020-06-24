/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
EXCEÇÕES
 */
package aula9;

/**
 *
 * @author CEITELABINFO
 */
public class Operacao {
    
    private int resultado = 0;
    
    public int dividir (int divisor) throws ArithmeticException {
        this.resultado = this.resultado / divisor;
        return resultado;
    }
    
    public int mod (int divisor) throws ArithmeticException {
        this.resultado = this.resultado % divisor;
        return resultado;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
    
    
}
