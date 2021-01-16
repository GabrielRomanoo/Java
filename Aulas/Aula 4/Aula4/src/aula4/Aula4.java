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
public class Aula4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        //quando chama o construtor counter,ele ja da ++, entao inicializa com 1
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        
        c1.contar2em2();
        c2.somar1();
        c3.contar2em2();
        
        System.out.println("Contador 1...:"+ c1.getCount());
        System.out.println("Contador 2...:"+ c2.getCount());
        System.out.println("Contador 3...:"+ c3.getCount());
        
        //abaixo, nao instacia o objeto porque o metodo divCount é static
        System.out.println("Metade...:"+ Counter.divCount());
        
        System.out.println("Cubo de 3...:"+ Calculate.cube(3));
        
        System.out.printf("Entre com o valor do raio: ");
        double raio = sc.nextDouble();
        
        System.out.println("Calcular area do raio...:"+raio+"..:"+Calculate.calcularArea(raio));
        System.out.println("Calcular perimetro do raio...:"+raio+"..:"+Calculate.calcularPerimetro(raio));
        //System.out.println("Valor de PI...:"+Math.PI);
        
        //short é um int pequeno vai de -32 a 31
        short op;
        
        System.out.println("Entre com a sua opcao");
        System.out.println("1-Inteiro ; 2-String ; 3-Float ; 4-Short ; 5-Byte");
        System.out.print("Opcao: ");
        op = sc.nextShort();
        
        switch(op) {
            
            case 1:
                System.out.println("Valor de PI em inteiro...:"+ ConvertePI.converteInteiro());
                                                                //so da pra chamar a classe direto, sem nenhum objeto instanciado, pq os metodos sao estaticos
                break;
                
            case 2:
                System.out.println("Valor de PI em String...:"+ ConvertePI.converteString());
                break;
                
            case 3:
                System.out.println("Valor de PI em Float...:"+ ConvertePI.converteFloat());
                break;
                
            case 4:
                System.out.println("Valor de PI em Short...:"+ ConvertePI.converteShort());
                break;
                
            case 5:
                System.out.println("Valor de PI em Byte...:"+ ConvertePI.converteByte());
                break;
        }
        
        
    }
    
}
