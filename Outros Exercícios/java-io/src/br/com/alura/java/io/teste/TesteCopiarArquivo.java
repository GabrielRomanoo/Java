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
 * ANOTA��ES
 * 
 * Temos os mundos da entrada Input, e da sa�da, Output. 
 * Estes mundos se subdividem em InputStream e Reader no primeiro caso, 
 * e OutputStream e Writer no segundo.
 * 
 * Al�m disso, temos a divis�o entre streams, e readers e writers. 
 * InputStream e OutputStream lidam com dados bin�rios, por exemplo imagens e PDFs, 
 * j� se estivermos lidando com caracteres, utilizamos o Reader ou Writer.
 * 
 * H� ainda as classes que fazem a transi��o de um mundo para outro, 
 * como � o caso da InputStreamReader, que recebe um InputStream de bytes 
 * e o transforma em um Reader. Da mesma forma, temos o OutputStreamWriter, 
 * que faz o mesmo, s� que para a escrita.
 * 
 */

public class TesteCopiarArquivo {

	public static void main(String[] args) throws IOException {
		
		Socket s = new Socket(); //exemplo de fluxo em rede
		/* Neste caso, n�o ir� executar, pois � preciso ter a conex�o do outro lado */
	
		//InputStream fis = s.getInputStream();	 //rede
		//InputStream fis = new FileInputStream("lorem.txt"); //arquivo
		InputStream fis = System.in; //usa o teclado como uma entrada, no caso, pega a sa�da do teclado e usa como entrada para o fluxo de dados
		Reader isr = new InputStreamReader(fis); 
		BufferedReader br = new BufferedReader(isr);

		//OutputStream fos = s.getOutputStream();	//rede
		//OutputStream fos = new FileOutputStream("lorem2.txt"); //arquivo
		OutputStream fos = System.out; //usa o console como uma sa�da
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
