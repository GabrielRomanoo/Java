/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lousa;

import java.util.Scanner;
/**
 *
 * @author CEITELABINFO
 */
public class Lousa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        Jogador j1 = new Jogador("gabriel",0);
        Jogador j2 = new Jogador("jaime",0);
        
        int empate;
        empate = 1;
        
        while (empate != 0) {
        
            System.out.println("\nPedra -> 0");
            System.out.println("Papel -> 1");
            System.out.println("Tesoura -> 2");
            
            System.out.println("Sua Jogada: ");
            j1.setMao(sc.nextInt());
            
            System.out.println("Outro Jogador: ");
            j2.setMao(sc.nextInt());
            
            
            
            if (j1.compareTo(j2) > 0) {
                System.out.println("Vencedor: "+j1.getNome());
                empate = 0;
            }
            if (j1.compareTo(j2) < 0) {
                System.out.println("Vencedor: "+j2.getNome());
                empate = 0;
            }
            if (j1.compareTo(j2) == 0) {
                System.out.println("Empate");
            }   
        }
        
        
    }
    
}
