/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4;

import java.util.Scanner;

/**
 *
 * @author CEITELABINFO
 */
public class Controle {
    
    
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
    
         int op = 0;
         
         TV.ligarControle();
         
         while (op != 2) {          
             
            System.out.println("\n1 - LIGA A TV");
            System.out.println("2 - DESLIGA A TV");
            System.out.println("3 - AUMENTAR O CANAL");
            System.out.println("4 - DIMINUIR O CANAL");
            System.out.println("5 - AUMENTAR VOLUME");
            System.out.println("6 - DIMINUI VOLUME");
            
            System.out.print("\nOP...: ");
            op = sc.nextInt();
            
            switch (op) {
                
                case 1:
                    TV.enviar(TV.liga_TV);
                    break;
                    
                case 2:
                    TV.enviar(TV.desliga_TV);
                    break;
                    
                case 3:
                    TV.enviar(TV.aumenta_Canal);
                    break;
                    
                case 4:
                    TV.enviar(TV.diminui_Canal);
                    break;
                
                case 5:
                    TV.enviar(TV.aumenta_Volume);
                    break;
                
                    
                case 6:
                    TV.enviar(TV.diminui_Volume);
                    break;
                
            }
            
         }
     }
    
}
