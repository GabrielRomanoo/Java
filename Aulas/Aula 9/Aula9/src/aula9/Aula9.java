/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula9;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author CEITELABINFO
 */
public class Aula9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String opa;
        
        int digitado = 0;
        
        Scanner sc = new Scanner(System.in);
        
        Operacao op = new Operacao();
        
        char key = 0;
        
        while (key != 27) { 
            try {
                System.out.println(">> "+op.getResultado());
                System.out.println("Digite a Operação: ");
                opa = sc.next();
                key = opa.charAt(0);
                System.out.println(">> "+ key);
                System.out.println("Digite um numero..: ");
                digitado = sc.nextInt();
                switch(key) {
                    case 47: op.dividir(digitado);
                             break;
                    case 61: op.setResultado(digitado);
                             break;
                    case 37: op.mod(digitado);
                             break;
                    case 27: System.out.println("Encerrando o programa");
                             break;
                }
            }
            
            catch(ArithmeticException ae) {
                System.out.println("Erro aritimetico " +ae.getMessage());
            }
            catch(InputMismatchException me) {
                System.out.println("Erro" +me.getMessage());
            }
        }
    }
    
}
