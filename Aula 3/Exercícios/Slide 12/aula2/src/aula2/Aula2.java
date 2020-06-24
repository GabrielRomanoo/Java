/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula2;

import java.util.Scanner;
        
/**
 *
 * @author CEITELABINFO
 */
public class Aula2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        //sc é um objeto, que instancia uma classe
        /*
        System.out.printf("Entre com um numero inteiro..: ");
        
        int num =  sc.nextInt();
        //newInt é um metodo
        
        System.out.println("Voce digitou: "+num);
        */
       
        System.out.printf("Qual o consumo medio? ");
        float cm = sc.nextFloat();
        
        System.out.printf("Quantos litros ele possui no tanque? ");
        float litros = sc.nextFloat();
        
        Carro c1 = new Carro(litros,1000,cm,0);
        
        //nao seria necessario fazer isso, pq ja tem no contrutor acima  c1.setConsumoMedio(cm);
        /*
        Carro c2 = new Carro(20,5000,10,0);
        Carro c3 = new Carro(10,40000,9,10000);
        
        */
        
        do {
        
        System.out.printf("\nQual a velocidade media dos carros? ");
        float vm = sc.nextFloat();
        
        System.out.printf("Por quanto tempo? ");
        float tempo = sc.nextFloat();
        
        c1.setarVelocidade(vm, tempo);
        /*
        c2.setarVelocidade(vm, tempo);
        c3.setarVelocidade(vm, tempo);
        */
        
        System.out.println("\nCarro 1 odometro: "+c1.odometro);
        System.out.println("Carro 1 tanque: "+c1.tanque);
        if (c1.isValidTrocarPneu()) {
            System.out.println("É preciso trocar o pneu");
        }
        else {
            System.out.println("Não é preciso trocar o pneu");
        }
        
        /*
        System.out.println("Carro 2 odometro: "+c2.odometro);
        System.out.println("Carro 2 tanque: "+c2.tanque);
        if (c2.trocaPneu == true) {
            System.out.println("É preciso trocar o pneu");
        }
        else {
            System.out.println("Não é preciso trocar o pneu");
        }
        System.out.println("Carro 3 odometro: "+c3.odometro);
        System.out.println("Carro 3 tanque: "+c3.tanque);
        if (c3.trocaPneu == true) {
            System.out.println("É preciso trocar o pneu");
        }
        else {
            System.out.println("Não é preciso trocar o pneu");
        }
        */
        } while(c1.tanque >= 0);
    }
}
    

