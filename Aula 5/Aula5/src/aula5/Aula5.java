/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula5;

import java.util.HashSet;

/**
 *
 * @author CEITELABINFO
 */
public class Aula5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Caixa func1 = new Caixa("Gabriel","15092000.00",3000.00);
        Caixa func2 = new Caixa("Jaime","10.10.2000.02",3500.00);
        func1.setSenha(1234);
        func2.setSenha(4567);
        
        Gerente gerente = new Gerente("Ciro","15.02.2000.03",10000.00,2);
        gerente.setSenha(8911);
        /*
        func1.setSenha(1234);
        func2.setSenha(2345);
        
        gerente.setSenha(6789);
        //como Gerente é filho de Funcionario, ele usa o set que esta em Funcionario
        
        System.out.println("Autenticando"+gerente.getNome()+"senha 1234 ..."+gerente.autenticar(1234));
        System.out.println("Autenticando"+func1.getNome()+"senha 1234 ..."+func1.autenticar(1234));
        System.out.println("Autenticando"+func2.getNome()+"senha 1234 ..."+func2.autenticar(1234));
        */
        
        //nao estamos istanciando objeto abaixo (n daria, pq a classe é abstrata), estamos istanciando um vetor na verdade (isso é uma caracteristica de polimorfismo (podemos encachar o caixa e gerente no funcionario
        Funcionario funcs[] = new Funcionario[3];
        funcs[0] = func1;
        funcs[1] = func2;
        funcs[2] = gerente;
        
        //é uma passagem por referencia, por nao ser um tipo primitivo(vetor nao é tipo primtivo, assim como os objetos)
        calcularBonusTodos(funcs);
        
        //se o parametro é um tipo primitivo, o passagem é por valor, e nao tipo primitivo
        
        /*
        System.out.println("Salario do "+gerente.getNome()+"+..:"+gerente.getSalario());
        System.out.println("Salario do "+func1.getNome()+"+..:"+func1.getSalario());
        System.out.println("Salario do "+func2.getNome()+"+..:"+func2.getSalario());
        */
        
        for (Funcionario f: funcs) {
            System.out.println("Salario do "+f.getNome()+"..: "+f.getSalario());
        }
        
        Cliente cliente = new Cliente();
        cliente.setEmail("gabriel@hotmail.com");
        cliente.setSenha(7810);
        
        System.out.println(validarLogin(func1,1234));
        System.out.println(validarLogin(func2,1234));
        System.out.println(validarLogin(gerente,1234));
        System.out.println(validarLogin(cliente,7810));
    }
    
    private static void calcularBonusTodos(Funcionario f[]) {
        /*
        for (int i = 0; i < f.length; i++) {
            f[i].calcularBonus();
        }
        */
        //precisa ter o metodo calcularBonus em Funcionarios, mesmo que vazio, pois usamos o polimorfismo e ele ja sabe qual calcular bonus é pro gerente e caixa, pois reescrevemos esse metodo nas suas respectivas classes
        for (Funcionario func: f) {
            func.calcularBonus();
        }
        //faz a mesma coisa do for de cima. no entanto, o for de cima da pra ter mais controle
    }
    
    private static boolean validarLogin(Autenticavel ia, int p) {
        return ia.autenticar(p);
    }
}
