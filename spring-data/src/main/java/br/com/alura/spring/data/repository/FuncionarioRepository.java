package br.com.alura.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

	// Derived Query (query's geradas pelo framework spring)
	List<Funcionario> findByNome(String nome);
	
	// JPQL
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :nome "
			+ "AND f.salario >= :salario AND f.dataContratacao = :data")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double Salario, LocalDate data);
	
	// variação usando Derived Query
	List<Funcionario> findByNomeAndSalarioGreaterThanAndDataContratacao(String nome, Double Salario, LocalDate data);

}

/* ANOTAÇÕES ABAIXO */

/* Exemplos de derived queries: */

/*
 * Usando Like 
 * 
 * Para executar um like (e não um equals, como no exemplo), use:
 * 
 * List<Funcionario> findByNomeLike(String nome);
 * 
 * O valor do parâmetro nome deve usar o pattern, por exemplo: String nome =
 * "%maria%";
 *
 * ----------------------------------------------------------------
 *
 * Starting e Ending 
 * 
 * Você também pode buscar os funcionários pelo prefixo ou
 * sufixo:
 * 
 * List<Funcionario> findByNomeEndingWith(String nome);
 * 
 * Ou:
 * 
 * List<Funcionario> findByNomeStartingWith(String nome);
 *
 * ----------------------------------------------------------------
 *
 * Null e not Null 
 * 
 * Igualmente podemos pesquisar elemento nulos ou não nulos:
 * 
 * List<Funcionario> findByNomeIsNull();
 * 
 * Ou não nulos com:
 * 
 * List<Funcionario> findByNomeIsNotNull()
 * 
 * ----------------------------------------------------------------
 * 
 * Ordenação 
 * 
 * Ainda vamos falar sobre ordenação e páginas, mas claro que a
 * Derived Query pode dar suporte:
 * 
 * List<Funcionario> findByNomeOrderByNomeAsc(String nome);
 * 
 * ----------------------------------------------------------------
 * 
 * Métodos longos E como dica, como definimos os critérios de pesquisa por meio
 * do nome do método, precisamos ter cuidado para não criar nomes gigantes e
 * prejudicar a legibilidade. Nesse caso devemos favorecer as consultas com
 * JPQL.
 * 
 * ----------------------------------------------------------------
 * 
 * Documentação 
 * 
 * Por fim aqui está a documentação do Spring Data JPA, com mais
 * exemplos.
 * 
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query
 * -methods
 */
