/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author ferauche
 */
public class Eleicoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UrnaException, EntradaException {
        // TODO code application logic here
        
        
            Scanner sc = new Scanner(System.in);

            Urna urna = new Urna();
            int votos = 0;
            while(votos < urna.getVotos().length) { 
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
                    else {
                        throw new EntradaException("So pode ser 'S'");
                        //aqui é sem s o throw
                    }
                }  
                catch(UrnaException ue) {
                    System.out.println("Deseja votar mesmo em 0? S/N");
                    String op2 = sc.next();
                    if (op2.equals("S")) {
                        urna.inserirVoto(0);
                        votos++;
                    }
                }
                catch(InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
                catch(EntradaException o) {
                    System.out.println(o.getMessage());
                }
                //tratamento é ter o try e catch
            }
            mostrarResultados(urna);    
      
}
        
        
    
    
    public static void mostrarResultados(Urna u) throws UrnaException {
        int[][] total = u.contabilizar();
        
        System.out.println("Resultado da eleicao");
        
        for(int i=0; i<total.length; i++) {
            Candidato c = u.getCandidato(total[i][0]);
            System.out.println(c.getNome());
            System.out.println("Total de votos..: "+total[i][1]);
        }
    }  
}
