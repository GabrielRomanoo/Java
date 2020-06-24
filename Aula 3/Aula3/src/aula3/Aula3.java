/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3;

/**
 *
 * @author CEITELABINFO
 */
public class Aula3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Disciplina poo = new Disciplina(5.0f, 7.5f);
        poo.setNome("Programação Orientada a Objetos"); 
        poo.calcularMedia();
        //poo é um objeto,uma instacia da classe Disciplina
        
        String nomeCaixaAlta = poo.getNome().toUpperCase();
        //por ser string,e nao ser um tipo primitivo, esseobjetyo nomeCaixaAlta nao precisa de new;
        //System.out.println("Nota...: "+poo.nota1);
        //nao é possivel fazer isso acima pq os atributos sao privados, 
        //apenas o metodos tem acesso, como no caso o getNota, que é um metodo publico
        
        //System.out.println("Disciplina...: " + poo.getNome());
        System.out.println("Disciplina...: " + nomeCaixaAlta);
        System.out.println("Nota 1...: " + poo.getNota1());
        System.out.println("Nota 2...: " + poo.getNota2());
        System.out.println("Media...: " + poo.getMedia()); 
        
    }
    
}
