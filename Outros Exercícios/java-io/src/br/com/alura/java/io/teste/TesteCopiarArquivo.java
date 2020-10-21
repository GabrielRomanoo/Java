package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

/*
 * ANOTAÇÕES
 * 
 * Temos os mundos da entrada Input, e da saída, Output. 
 * Estes mundos se subdividem em InputStream e Reader no primeiro caso, 
 * e OutputStream e Writer no segundo.
 * 
 * Além disso, temos a divisão entre streams, e readers e writers. 
 * InputStream e OutputStream lidam com dados binários, por exemplo imagens e PDFs, 
 * já se estivermos lidando com caracteres, utilizamos o Reader ou Writer.
 * 
 * Há ainda as classes que fazem a transição de um mundo para outro, 
 * como é o caso da InputStreamReader, que recebe um InputStream de bytes 
 * e o transforma em um Reader. Da mesma forma, temos o OutputStreamWriter, 
 * que faz o mesmo, só que para a escrita.
 * 
 */

public class TesteCopiarArquivo {

	public static void main(String[] args) throws IOException {
		
		Socket s = new Socket(); //exemplo de fluxo em rede
		/* Neste caso, não irá executar, pois é preciso ter a conexão do outro lado */
	
		//InputStream fis = s.getInputStream();	 //rede
		//InputStream fis = new FileInputStream("lorem.txt"); //arquivo
		InputStream fis = System.in; //usa o teclado como uma entrada, no caso, pega a saída do teclado e usa como entrada para o fluxo de dados
		Reader isr = new InputStreamReader(fis); 
		BufferedReader br = new BufferedReader(isr);

		//OutputStream fos = s.getOutputStream();	//rede
		//OutputStream fos = new FileOutputStream("lorem2.txt"); //arquivo
		OutputStream fos = System.out; //usa o console como uma saída
		Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		String linha = br.readLine();
		
		while (linha != null && !linha.isEmpty()) { //usa o isEmpty para poder parar quando tiver uma linha vazia
			bw.write(linha);
			bw.newLine();
			bw.flush(); //como se fosse uma descarga do buffer
			linha = br.readLine();
		}
		
		bw.close();
		br.close();		
	}

}
