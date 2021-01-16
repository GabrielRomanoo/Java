package br.com.alura.java.io.teste;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/*
 * Anota��es
 * 
 * Nesta linha : FileInputStream fis = new FileInputStream("lorem.txt");
 * temos que usar o throws ou fazer um try catch, pois existe uma exce��o checked nesta classe
 * caso a exce��o ocorra, � jogada uma bomba no lugar da declara��o do throws,
 * no caso, na main.
 * 
 * Nesta linha: InputStreamReader isr = new InputStreamReader(fis); 
 * temos que usar esta classe pois o FileInputStream nos retorna apenas bits e bytes. 
 * assim, essa classe InputStramReader converte esses bytes em caracter
 * passamos o fis para o construtor do InputStreamReader pois o fis � um fluxo de entrada
 * 
 * Nesta linha: BufferedReader br = new BufferedReader(isr);
 * temos que usar esta classe para guardar varios caracteres de uma vez.
 * se fossemos usar apenas o InputStreamReader, ele iria ler caracter por caracter. 
 * dessa forma, ter�amos que guardar cada um dos caracteres em um array.
 * para evitar isso, usamos o BufferReader, que nos permite ler uma linha.
 * ele guarda nossos caracteres at� preencher uma linha.
 */

public class TesteLeitura {

	public static void main(String[] args) throws IOException {

		//Fluxo de Entrada com Arquivo
		
		InputStream fis = new FileInputStream("lorem.txt"); //Criando o fluxo concreto com arquivo, mas binario
		Reader isr = new InputStreamReader(fis, "UTF-8"); //Melhorando os dados bin�rios para caracteres
		BufferedReader br = new BufferedReader(isr);
		//Padrao de Projeto Decorator (um objeto conhece o outro, embrulha o outro)
		
		String linha = br.readLine();
		
		while (linha != null) {
			System.out.println(linha);
			linha = br.readLine(); //O m�todo readLine l� a pr�xima linha toda vez que � chamad
		}
		
		
		
		br.close();
		
	}

}
