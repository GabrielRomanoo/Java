package br.com.alura.java.io.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacaoCliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
//		Cliente cliente = new Cliente();
//		cliente.setNome("Nico");
//		cliente.setProfissao("Dev");
//		cliente.setCpf("234113131");
//
//		//quando a classe tiver que ser serializada, ela precisa assinar o contrato Serializable (implementar)
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
//		oos.writeObject(cliente); 
//		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cliente.bin"));
		Cliente cliente = (Cliente) ois.readObject(); //desserializando, é a criação de um objeto a partir de um fluxo binário de dados
		ois.close();
		
		System.out.println(cliente);
		System.out.format("%s, %s, %s%n", cliente.getNome(), cliente.getProfissao(), cliente.getCpf());

	}

}
