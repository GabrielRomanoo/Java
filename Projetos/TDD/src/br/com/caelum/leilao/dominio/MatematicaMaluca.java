package br.com.caelum.leilao.dominio;

public class MatematicaMaluca {

	public int contaMaluca(int numero) {
        if (numero > 30)
            return numero * 4;
        else if (numero > 10)
            return numero * 3;
        else
            return numero * 2;
    }
	/*
	 * Precisamos de no mínimo 3 testes para garantir que esse método funcione.
	 * 
	 * Um para o caso onde o número é maior que 30; 
	 * outro para o caso onde o número é maior que 10, mas menor que 30; 
	 * outro para o caso onde o número é menor que 10.
	 * 
	 * Podemos ainda aumentar nossa segurança, e testar o que acontece quando 
	 * passamos exatamente os números 10 e 30, afinal são casos extremos e merecem ser testados.
	 * 
	 * Próximo ao infinito também poderia ser considerado uma resposta válida, 
	 * afinal para garantirmos que esse método funcione com toda certeza, 
	 * precisaríamos testá-lo com todos os números inteiros válidos. 
	 * Infelizmente, escrever essa quantidade de testes é impossível e caro.
	 */
}
