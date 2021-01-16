/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

INTERFACE COMPARABLE
 */
package exeaula8;

import java.util.Arrays;

/**
 *
 * @author ferauche
 */
public class ExeAula8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Revolver rev = new Revolver();
        rev.setDestruicao(4.4);
        
        LancaChama lc = new LancaChama();
        lc.setDestruicao(1.2);
        
        Faca fc = new Faca();
        fc.setDestruicao(3.2);
        
        Arma armas[] = new Arma[3];
        armas[0] = rev;
        armas[1] = lc;
        armas[2] = fc;
        
        Arma[] oArmas = ordenarArmas(armas);
        
        for(Arma a : oArmas) {
            System.out.println(a.getDestruicao());
        }
            
    }
    
    public static Arma[] ordenarArmas(Arma[] a) {
        Arma[] ret = Arrays.copyOf(a, a.length);
        int result;
        Arma aux;
        for(int i=0; i<ret.length;i++) {
            for(int j=i; j<ret.length;j++) {
                result =  ret[i].compareTo(ret[j]);
                if(result < 0) {
                    aux = ret[i];
                    ret[i] = ret[j];
                    ret[j] = aux;
                }
            }
        }
        
        //Arrays.sort(ret);
        return ret;
    }
        
}
