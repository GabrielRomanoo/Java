package br.com.alura.java.io.teste;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

/*
 * No saldo, temos um ponto (.) separando os n�meros inteiros dos decimais, contudo, 
 * alguns lugares convencionam o ponto, enquanto outros utilizam a v�rgula (,) para este fim. 
 * O que determina se a m�quina virtual seguir� um padr�o ou outro � o sistema operacional 
 * da m�quina, ela seguir� o padr�o do idioma da m�quina em que o c�digo est� sendo escrito.
 * Por exemplo, como neste curso estamos utilizando uma m�quina cujo sistema est� em Ingl�s, 
 * o padr�o � o ponto (.), se tentarmos utilizar outro caractere, ocorrer� um erro.
 * Para evitar esta regra autom�tica, podemos especificar no c�digo a regra que queremos seguir 
 * utilizando o m�todo useLocale().
 * Nela, acessaremos o nome da classe, portanto Locale, seguida de um ponto (.), 
 * e o Eclipse nos mostrar� uma s�rie de op��es de regras. 
 * No caso, utilizaremos US, que � o padr�o americano.
 * Desta forma, n�o importa o sistema operacional, o c�digo e a m�quina virtual sempre respeitar�o o padr�o americano.
 * 
 * Na linha: linhaScanner.useDelimiter(",");
 * n�s definimos o nosso caractere de separa��o
 * o objeto linhaScanner tem uma variavel private que guarda o caractere de sepa��o
 * o m�todo useDelimeter � respons�vel por separar o conte�do por um delimitador
 * 
 */

public class TesteLeituraScanner {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(new File("contas.csv"),"UTF-8");
		
		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine(); //retorna uma string que � a linha (come�a pela primeira)
//			System.out.println(linha);
			
			Scanner linhaScanner = new Scanner(linha); //criamos outro scanner para setorizar as linhas
			linhaScanner.useLocale(Locale.US); //verificar anota��es
			linhaScanner.useDelimiter(","); 
			
			String tipoConta = linhaScanner.next();
			int agencia = linhaScanner.nextInt(); //faz o parsing automaticamente
			int numero = linhaScanner.nextInt();
			String titular = linhaScanner.next();
			double saldo = linhaScanner.nextDouble();
			
			//poderia usar um Locale.GERMANY, pois as regras de formta��o s�o muito parecidas com a do Brasil
//			String valorFormatado = String.format(new Locale("pt","BR"), "%s -%04d-%08d, %20s : %08.2f", //usa esse locale para formatar no estilo alem�o (usar "," no double)
//													tipoConta, agencia, numero, titular, saldo);
//			System.out.println(valorFormatado); //concatenar muitas strings � m� pr�tica
			

			System.out.format(new Locale("pt","BR"), "%s - %04d-%08d, %20s : %08.2f %n",tipoConta, agencia, numero, titular, saldo);
			
			
			
			//System.out.println(tipoConta + agencia + numero + titular + saldo); //concatenar muitas strings � m� pr�tica
			
			linhaScanner.close();
						
//			String[] valores = linha.split(","); //o split separa uma String grande em peda�os menores
//			System.out.println(Arrays.toString(valores));
			
		}
		scanner.close();	
	}
}
