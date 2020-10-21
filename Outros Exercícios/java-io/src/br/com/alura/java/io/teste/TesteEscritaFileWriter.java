package br.com.alura.java.io.teste;

import java.io.BufferedWriter;

/*
 * ANOTA��ES
 * 
 * A classe Filewriter trabalha diretamente com um arquivo que j� cont�m caracteres
 * Dessa forma, ela substitui a linha que contem OutputStream e Writer.
 * 
 * Contudo, FileWriter � um Writer e n�o um OutputStream.
 * Para ser mais espec�fico, a classe FileWriter estende a classe OutputStreamWriter, 
 * que por sua vez estende a classe Writer. 
 * Ent�o o FileWriter � um OutputStreamWriter e � um Writer.
 */
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteEscritaFileWriter {

	public static void main(String[] args) throws IOException {

//		OutputStream fos = new FileOutputStream("lorem2.txt");
//		Writer osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
		
//		FileWriter fw = new FileWriter("lorem2.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt")); //estamos embrulhando a sa�da FileWriter em um BufferedWriter
		bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
//		bw.write(System.lineSeparator()); //esse metodo retorna o \n perante cada SO
		bw.newLine();
		bw.newLine();
		bw.write("dhsdhasuih has hdisuah d asd");
	
		
		bw.close();
		
	}

}
