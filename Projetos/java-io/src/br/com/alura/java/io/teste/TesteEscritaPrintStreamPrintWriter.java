package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.File;
/*
 * ANOTAÇÕES
 * 
 * A classe Filewriter trabalha diretamente com um arquivo que já contém caracteres
 * Dessa forma, ela substitui a linha que contem OutputStream e Writer.
 * 
 * Contudo, FileWriter é um Writer e não um OutputStream.
 * Para ser mais específico, a classe FileWriter estende a classe OutputStreamWriter, 
 * que por sua vez estende a classe Writer. 
 * Então o FileWriter é um OutputStreamWriter e é um Writer.
 */
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

public class TesteEscritaPrintStreamPrintWriter {

	public static void main(String[] args) throws IOException {
		
		long ini = System.currentTimeMillis(); //usa para contar o tempo da execução do programa

//		OutputStream fos = new FileOutputStream("lorem2.txt");
//		Writer osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
		
//		FileWriter fw = new FileWriter("lorem2.txt");
//		BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));
		
//		PrintStream ps = new PrintStream("lorem2.txt");
//		PrintStream ps = new PrintStream(new File("lorem2.txt")); // poderiamos ter definido um caminho no construtor do file
	
		PrintWriter ps = new PrintWriter("lorem2.txt","UTF-8"); //para passar o charset e dar certo, tem que mudar o tipo de enconding nas propriedades do arquivo 
		
		ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		ps.println();
		ps.println();
		ps.println();
		ps.println("dhsdhasuih has hdisuah d asd");
				
		ps.close();
		
		long fim = System.currentTimeMillis();

        System.out.println("Passaram " + (fim - ini) + " milissegundos");

		
	}

}
