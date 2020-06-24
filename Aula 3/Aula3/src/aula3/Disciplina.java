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
public class Disciplina { 
    //se tirar o publico acima,a classe se torna visivel apenas apara o mesmo pacote,no caso as calsses do pacote aula3
    
    float nota1; //defaut,sem nada ele é pacote,package
    private float nota2;//<- atributo
    private float media;
    private String nome; //string nao é primitivo
    //apenas os metodos tem acesso aos atributos privados
    
    public Disciplina(float n1, float n2){ //<- construtor
        this.nota1 = n1;
        this.nota2 = n2; 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }   
    
    public float getNota1() {
        return this.nota1;
    }
    
    public float getNota2() {
        return this.nota2;
    }
    
    public void setNota1(float n1) {
        this.nota1 = n1;
    }
    
    public void setNota2(float n2) {
        this.nota2 = n2;
    }
    
    public float calcularMedia(){
        this.media = (this.nota1 + this.nota2)/2;
        return this.media;
    }
    
    //encapsulamento é deixar o atributos privados e os metodos publicos
    //metodos getters(get) e setters(set) garantem o encapsulamento

    //para gerar rapidamentos os gets e sets soclicar com o botao direito,
    //e depois inseriro codigo, e clicar em gets e sets
    
    public float getMedia() {
        return media;
    }
}
