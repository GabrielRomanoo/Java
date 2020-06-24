/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lousa;

/**
 *
 * @author CEITELABINFO
 */
public class Jogador implements Comparable<Jogador>{
    
    private String nome;
    private int mao;

    public Jogador(String nome, int mao) {
        this.nome = nome;
        this.mao = mao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMao() {
        return mao;
    }

    public void setMao(int mao) {
        this.mao = mao;
    }
    
    
    
    @Override
    public int compareTo(Jogador j){
        // referencia aqui em cima é o 2 jogador
        
        if (this.mao == 0 && j.mao == 2) {
            return 1;
        }
        
        if (this.mao == 2 && j.mao == 0) {
            return -1;
        }
        
        if (this.mao == 2 && j.mao == 1) {
            return 1;
        }
        
        if (this.mao == 1 && j.mao == 0) {
            return 1;
        }
        
        if (this.mao == 1 && j.mao == 2) {
            return -1;
        }
        
        if (this.mao == 0 && j.mao == 1) {
            return -1;
        }
        
        if (this.mao == j.mao ) {
            return 0;
        } 
        else {
            return -9;
        }
    }
}
