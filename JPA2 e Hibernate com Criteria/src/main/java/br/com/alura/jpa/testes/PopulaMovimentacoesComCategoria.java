package br.com.alura.jpa.testes;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class PopulaMovimentacoesComCategoria {

    public static void main(String[] args) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

        Categoria categoria1 = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Negócios");

        Conta conta = new Conta();
        conta.setTitular("Maria");
        conta.setAgencia(9876);
        conta.setNumero(124512);
        conta.setSaldo(500.0);
        
        Conta conta2 = new Conta();
        conta2.setTitular("Bruno");
        conta2.setAgencia(6543);
        conta2.setNumero(169878);
        conta2.setSaldo(1300.0);

        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setData(LocalDateTime.now()); // hoje
        movimentacao1.setDescricao("Viagem à SP");
        movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal(100.0));
        movimentacao1.setCategorias(Arrays.asList(categoria1));

        movimentacao1.setConta(conta2);

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setData(LocalDateTime.now().plusDays(1)); // amanhã
        movimentacao2.setDescricao("Viagem ao RJ");
        movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal(300.0));
        movimentacao2.setCategorias(Arrays.asList(categoria2));

        movimentacao2.setConta(conta2);
        
        em.getTransaction().begin();
        
        em.persist(categoria1); 
        em.persist(categoria2); 

        em.persist(conta);
        em.persist(conta2);
        
        em.persist(movimentacao1);
        em.persist(movimentacao2);
       
        em.getTransaction().commit();
        em.close();

    }
}