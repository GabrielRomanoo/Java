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
	 * Precisamos de no m�nimo 3 testes para garantir que esse m�todo funcione.
	 * 
	 * Um para o caso onde o n�mero � maior que 30; 
	 * outro para o caso onde o n�mero � maior que 10, mas menor que 30; 
	 * outro para o caso onde o n�mero � menor que 10.
	 * 
	 * Podemos ainda aumentar nossa seguran�a, e testar o que acontece quando 
	 * passamos exatamente os n�meros 10 e 30, afinal s�o casos extremos e merecem ser testados.
	 * 
	 * Pr�ximo ao infinito tamb�m poderia ser considerado uma resposta v�lida, 
	 * afinal para garantirmos que esse m�todo funcione com toda certeza, 
	 * precisar�amos test�-lo com todos os n�meros inteiros v�lidos. 
	 * Infelizmente, escrever essa quantidade de testes � imposs�vel e caro.
	 */
}
