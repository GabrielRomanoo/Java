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
public class Candidato implements Comparable<Candidato> {
    
    private int numero;
    private String nome;
    private int totalVotos = 0;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        this.totalVotos = totalVotos;
    }

    @Override
    public int compareTo(Candidato t) {
        return t.getTotalVotos() - this.getTotalVotos();
        //aqui é decrescente, ao contrario seria crescente
    }
    
    
    
}
