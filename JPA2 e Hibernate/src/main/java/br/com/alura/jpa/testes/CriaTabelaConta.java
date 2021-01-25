package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaTabelaConta {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas"); // mudar o persistence-unit name no persistence.xml para "contas"
		EntityManager createEntityManager = emf.createEntityManager();
		emf.close();
	}

}
