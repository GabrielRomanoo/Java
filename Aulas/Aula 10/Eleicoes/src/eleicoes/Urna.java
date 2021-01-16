/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes;

/**
 *
 * @author ferauche
 */
public class Urna {
    private Candidato[] candidatos = new Candidato[2]; //lista de candidatos
    private int votos[] = new int[5]; //no máximo 5 votos
    private int idx = 0;
    
    public Urna() {
        Candidato c1 = new Candidato();
        c1.setNome("Bozo");
        c1.setNumero(71);
        
        Candidato c2 = new Candidato();
        c2.setNome("Maldad");
        c2.setNumero(31);
        
        candidatos[0] = c1;
        candidatos[1] = c2;
    }
    
    public Candidato getCandidato(int numero) throws UrnaException {
        Candidato c;
        for(int i=0;i<candidatos.length;i++) {
            c = candidatos[i];
            if(c.getNumero()==numero) {
                return c;
            }
        }
    throw new UrnaException("Candidato nao encontrado!");
    }
    
    public Candidato[] getCandidatos() {
        return this.candidatos;
    }
    
    public void inserirVoto(int numero) {
        votos[idx] = numero;
        idx++; 
    }
    
    public int[] getVotos() {
        return this.votos;
    }
    
    public int[][] contabilizar() {
        int total[][] = new int[candidatos.length][2];
        int x = 0;
        for(Candidato c : candidatos) {
            total[x][0] = c.getNumero();
            for(int v : votos) {
                if (c.getNumero() == v) total[x][1]++;
            }
            x++;
        }
        return total;
    }
    
}
