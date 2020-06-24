/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula.pkg13;

import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author CEITELABINFO
 */
public class Aula13 {
    //essa classe é um testset

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pessoa p1 = new Pessoa("Thiago","1656565656565");
        Pessoa p2 = new Pessoa("Adriana","16546556165");
        Pessoa p3 = new Pessoa("Thiago","1656565656565");
        
        HashSet<Pessoa> hset = new HashSet<Pessoa>();
        hset.add(p1);
        hset.add(p2);
        //hset.add(p3);
        //em hash, nao temos repetidos, no  entanto, quando adicionamos p3 (que é igual p1), ele aceita. isso ocorre, porque a validação nao funciona com objetos, já com strings, whaperclass, integer, etc..., funciona.
        exibir(hset);
        
    }
    
    private static void exibir(Collection<Pessoa> pessoas){
        for(Pessoa p: pessoas) {
            System.out.println(p.getNome()+" "+p.getRG());
        }
        
    }
}
