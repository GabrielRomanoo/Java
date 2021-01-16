package br.com.bytebank.banco.test;

/* 
 * A String � uma classe definida em java.lang e por isso n�o h� a necessidade de importar.
 * Um objeto do tipo String n�o pode ser alterado, ou seja, � imut�vel
 * 
 */

public class TesteString {

	public static void main(String[] args) {
		
		String vazio = "     Alura     ";
		String outroVazio = vazio.trim(); //tira os espa�os da string
		
		System.out.println(vazio.contains("Alu"));
		System.out.println(outroVazio);
		System.out.println(vazio.isEmpty());
		
		String nome = "Alura"; //objeto literal
		// n�o precisa usar o new para criar o objeto String
		//String outro = new String("Alura"); // m� pratica
		
		System.out.println(nome.length());
		
		for (int i = 0; i < nome.length(); i++) {
			System.out.println(nome.charAt(i));
		}
		
//		String sub = nome.substring(1); //retorna uma string a partir da posi��o passada
//		System.out.println(sub);
		
//		int pos = nome.indexOf("ur");
//		System.out.println(pos);
		
//		char c = nome.charAt(0);
//		System.out.println(c);
		
//		char c = 'A';
//		char d = 'a';
//		String outra = nome.replace(c, d); //a classe String � imutavel
		
		//String outra = nome.toUpperCase();
		
//		System.out.println(nome);
//		System.out.println(outra);
		
		String frase = "nome;teste;10";
		String array[] = new String[3];

		array = frase.split(";");
		
		System.out.println(array[0]);
		
		String texto = "Socorram";
		texto = texto.concat("-");
		texto = texto.concat("me");
		texto = texto.concat(", ");
		texto = texto.concat("subi ");
		texto = texto.concat("no ");
		texto = texto.concat("�nibus ");
		texto = texto.concat("em ");
		texto = texto.concat("Marrocos");
		System.out.println(texto); 
		
		//se toda string � imutavel, como que consigo concatenar ela, sem criar um objeto a mais para isso?

		String nome1 = "ALURA";
		CharSequence cs = new StringBuilder("al");

		nome1 = nome1.replace("AL", cs);

		System.out.println(nome1);
	}

}
