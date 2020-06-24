/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
 /*
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
        Vector<Integer> votos = new Vector<Integer>();
        //while(votos < urna.getVotos()) { 
        while(votos.equals(urna.getVotos())) { //nao se pode usar > ou < com objeto, por isso usamos o equals
            try {
                System.out.println("==== ELEICOES ====");
                System.out.print("Digite o numero o candidato..: ");
                int n = sc.nextInt();
            
                Candidato c = urna.getCandidato(n);
                System.out.print("Candidato "+c.getNome()+" confirma ? (S/N)");
                String op = sc.next();
                if(op.equals("S")) {
                    urna.inserirVoto(n);
                    votos.add(1);
                }
            }
            catch(UrnaException ue) {
                System.out.println(ue.getMessage());
                System.out.print("Confirma mesmo assim? (S/N)");
                String op = sc.next();
                if(op.equals("S")) {
                    urna.inserirVoto(0);
                    votos.add(1);
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
        Vector<Candidato> total = u.contabilizar();
        System.out.print("Resultado da eleicao ");
        Collections.sort(total); //usa o compaeTo para fazer o sort
        // collections.sort ela ordena por ordem crescente, usando o compareTo
        // quando vc da .sort, voce esta ordenando, independente do que for
        for (Candidato c : total) {
            System.out.println(c.getNome());
            System.out.println("Total de votos..: "+ c.getTotalVotos());
        }
        
    }  
}


