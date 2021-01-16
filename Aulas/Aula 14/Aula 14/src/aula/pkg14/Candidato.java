/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula.pkg14;

import java.util.*;

/**
 *
 * @author ferauche
 */
public class Candidato implements Comparable<Candidato> {
    
    private int numero;
    private String nome;
    private int total;

    public int compareTo(Candidato c) {
        int ret = this.total - c.getTotal();
        if(ret ==0 ) ret = 1;
        return ret;
    }
     
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
    
   
    
    
}
