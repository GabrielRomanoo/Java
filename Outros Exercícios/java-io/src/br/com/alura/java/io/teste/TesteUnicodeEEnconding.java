package br.com.alura.java.io.teste;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TesteUnicodeEEnconding {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
//PARA DAR CERTO A EXECUCAO, TEM QUE MUDAR O ENCONDING NAS PROPRIEDADES DO PROJETO PARA UTF-8

		//UNICODE
		String s = "ç";
		System.out.println(s.codePointAt(0)); //dizemos qual � a posi��o que queremos pegar o unicode, pois a string poderia ser "CCC"
		
		//ENCONDING
		Charset charset = Charset.defaultCharset(); //pegando o enconding do SO
		System.out.println(charset.displayName());
		
		byte[] bytes = s.getBytes("windows-1252"); //ctrl + 1 no final cria automaticamente uma variavel
		System.out.print(bytes.length + ", windows-1252, ");
		String sNovo = new String(bytes, "windows-1252");
		System.out.println(sNovo);
		//getBytes sem argumento utiliza o charset padrao do SO
		
		bytes = s.getBytes("UTF-16"); //converter em bytes 
		System.out.print(bytes.length + ", UTF-16, ");
		sNovo = new String(bytes, "UTF-16");
		System.out.println(sNovo);
		
		bytes = s.getBytes(StandardCharsets.US_ASCII); 
		System.out.print(bytes.length + ", US-ASCII, ");
		sNovo = new String(bytes, "US-ASCII");
		System.out.println(sNovo);

	}

}
