/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula.pkg14;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;
/**
 *
 * @author ferauche
 */
public class Eleicoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        Urna urna = new Urna();
        int votos = 0;
        while(urna.getVotos().size()<=5) { 
            try {
                System.out.println("==== ELEICOES ====");
                System.out.print("Digite o numero o candidato..: ");
                int n = sc.nextInt();
            
                Candidato c = urna.getCandidato(n);
                System.out.print("Candidato "+c.getNome()+" confirma ? (S/N)");
                String op = sc.next();
                if(op.equals("S")) {
                    urna.inserirVoto(n);
                    votos++;
                }
            }
            catch(UrnaException ue) {
                System.out.println(ue.getMessage());
                System.out.print("Confirma mesmo assim? (S/N)");
                String op = sc.next();
                if(op.equals("S")) {
                    urna.inserirVoto(0);
                    votos++;
                }
            }
            catch(InputMismatchException ime) {
                System.out.println("Entrada de dados incorreta!. Tente novamente!");
            }
        }
        try {
            mostrarResultados(urna);    
        }
        catch(UrnaException ue) {}
    }
    
    public static void mostrarResultados(Urna u) throws UrnaException {
        TreeSet<Candidato> apuracao = u.contabilizar();
            
        System.out.println("Resultado da eleicao");
        
        Candidato c = apuracao.last();
        
        System.out.println("Vencedor..: "+c.getNome());
        System.out.println("Total de votos..: "+c.getTotal());
    }  
}