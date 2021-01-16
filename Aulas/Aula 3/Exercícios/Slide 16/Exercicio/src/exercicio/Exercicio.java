/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicio;

/**
 *
 * @author CEITELABINFO
 */

import java.util.Scanner;

public class Exercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Tanque t1 = new Tanque(); //aqui to chamando a classe
    
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Informe o volume Maximo: ");
        float max = sc.nextFloat();
        t1.setVolumeMax(max);
        
        System.out.println("Informe o volume Minimo: ");
        float min = sc.nextFloat();
        t1.setVolumeMinimo(min);
        
        char opcao = 's';
        int opcao1;
        
        while (opcao == 's') {
            
            System.out.println("Voce quer encher ou esvaziar? Digite 1/2: ");
            opcao1 = sc.nextInt();
            
            if (opcao1 == 1) {
                t1.encher(10);
                
            }
            else {
                t1.esvaziar(10);
            }
            
           System.out.println(""+ t1.exibirInfos());
            
           System.out.println("Quer continuar? Digite s/n: ");
           opcao = sc.next().charAt(0); //pega a primeira letra da string
        } 
      
    }
    
}
