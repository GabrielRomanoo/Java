/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

import java.util.Scanner;

/**
 *
 * @author CEITELABINFO
 */
public class Exercicios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        Pessoa p[] = new Pessoa[3];
        
        int cont = 0;
        String nome;
        String endereco;
        double rend;
        String opcao;
        String cnpj;
        String cpf;
        
        while (cont < 3) {
            
            System.out.printf("\nInforme sua opcao (PJ/PF): ");
            opcao = sc.nextLine();
            
            switch (opcao) {
                
                case "PF":
                    
                    System.out.printf("\nNome..: ");
                    nome = sc.nextLine();
                    System.out.printf("\nEndereco..: ");
                    endereco = sc.nextLine();
                    System.out.printf("\nRendimentos..: ");
                    rend = sc.nextDouble();
                    sc.nextLine(); //limpando buffer
                    System.out.printf("\nCPF..: ");
                    cpf = sc.nextLine();
                    
                    p[cont] = new PF(nome,endereco,rend,cpf);
                                        
                    cont++;
                    break;
                    
                case "PJ":
                    
                    System.out.printf("\nNome..: ");
                    nome = sc.nextLine();
                    System.out.printf("\nEndereco..: ");
                    endereco = sc.nextLine();
                    System.out.printf("\nRendimentos..: ");
                    rend = sc.nextDouble();
                    sc.nextLine(); //limpando buffer
                    System.out.printf("\nCNPJ..: ");
                    cnpj = sc.nextLine();
                    
                    p[cont] = new PJ(nome,endereco,rend,cnpj);
                                        
                    cont++;
                    break;
            }
        }
        
        System.out.println("\nIMPOSTOS\n");
        calcularTodosImpostos(p);
    }
    
    public static void calcularTodosImpostos(Pessoa p[]){
        for (Pessoa x: p){
            System.out.println(x.calcularImposto()+" de Imposto do(a): "+x.getNome());
        }
    }   
}
