/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula5;

/**
 *
 * @author CEITELABINFO
 */
public class Cliente implements Autenticavel {
    
    private String email;
    private int senha;

    @Override
    public boolean autenticar(int p) {
        boolean retorno = false;
        if (this.senha == p) {
           retorno = true;
        }
        return retorno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
    
    
    
    
    
}
