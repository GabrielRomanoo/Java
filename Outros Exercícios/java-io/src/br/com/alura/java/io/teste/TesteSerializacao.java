package br.com.alura.java.io.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacao {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
//		String nome = "Gabriel Romano";
//		
//		//Transformando o Objeto nome em um fluxo de bits e bytes
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objeto.bin"));
//		oos.writeObject(nome); //serializando, é a transformação de um objeto em um fluxo binário
//		oos.close();
		
		//Transformando um fluxo de bits e bytes em um Objeto
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.bin"));
		String nome = (String) ois.readObject(); //desserializando, é a criação de um objeto a partir de um fluxo binário de dados
		ois.close();
		
		System.out.println(nome);
	}

}
