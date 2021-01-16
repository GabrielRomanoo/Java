/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes;

import java.util.Vector;

/**
 *
 * @author ferauche
 */
public class Urna {
    private Vector<Candidato> candidatos = new Vector<Candidato>(); //lista de candidatos
    private Vector<Integer> votos = new Vector <Integer>();
    //private int votos[] = new int[5]; //no máximo 5 votos
    //private int idx;
    
    public Urna() {
        Candidato c1 = new Candidato();
        c1.setNome("Bozo");
        c1.setNumero(71);
        
        Candidato c2 = new Candidato();
        c2.setNome("Maldad");
        c2.setNumero(31);
        
       candidatos.add(c1);
       candidatos.add(c2);
    }
    
    public Candidato getCandidato(int numero) throws UrnaException {
        for(Candidato c : candidatos) {
            if(c.getNumero()==numero) {
                return c;
            }
        }
        throw new UrnaException("Cadidato não encontrado!");
    }
    
    public Vector<Candidato> getCandidatos() {
        return this.candidatos;
    }
    
    public void inserirVoto(int numero) {
        votos.add(numero);
        //votos[idx] = numero;
        //idx++; 
    }

    public Vector<Integer> getVotos() {
        int x = votos.size();
        Vector<Integer> ob = new Vector<>(x);
        return ob;
    }
    /*
    public int[]getVotos() {
        return this.votos;
    }
    */
    
    
//    public int[][]contabilizar() {
//        int total[][] = new int[candidatos.size()][2];
//        int x = 0;
//        for(Candidato c : candidatos) {
//            total[x][0] = c.getNumero();
//            for(int v : votos) {
//                if (c.getNumero() == v) total[x][1]++;
//            }
//            x++;
//        }
//        return total;
//    }
    
    public Vector<Candidato> contabilizar() {
        int total;
        for(Candidato c : candidatos) {
            total = 0;
            for(Integer v : votos) {
                if (c.getNumero() == v) {
                    total++;
                }
            }
            c.setTotalVotos(total);

        }
        return this.candidatos;
    }
    
}
