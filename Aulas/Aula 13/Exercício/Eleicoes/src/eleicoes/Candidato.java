/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eleicoes;

import java.util.*;

/**
 *
 * @author ferauche
 */
public class Candidato implements Comparable<Candidato> {
    
    private int numero;
    private String nome;
    private int total = 0;
     
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
    
    public void setTotal(int x) {
        this.total =x;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    @Override
    public int compareTo(Candidato t) {
        
        if (t.getTotal() - this.getTotal() == 0) {
            return 1000;
        } else {
            return t.getTotal() - this.getTotal();
        }
        
        
        //aqui é decrescente, ao contrario seria crescente
    }
    
   
    
    
}
