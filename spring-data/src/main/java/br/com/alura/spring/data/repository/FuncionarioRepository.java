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
	
	// @Query (usando JPQL)
	
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :nome "
			+ "AND f.salario >= :salario AND f.dataContratacao = :data")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate data);
	
	// variação usando Derived Query
	List<Funcionario> findByNomeAndSalarioGreaterThanAndDataContratacao(String nome, Double Salario, LocalDate data);

	// Native Query (usando os atributos do banco de dados)
	@Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data",
			nativeQuery = true)
	List<Funcionario> findDataContratacaoMaior(LocalDate data);
}

/* ANOTAÇÕES ABAIXO */

/* 
 * Derived Query x @Query
 * 
 * Aprendemos que ao usar o Derived Query Methods o JPQL é gerado dinamicamente 
 * (ou derivado) baseado no nome do método. Não mostramos, 
 * mas claro que isso também funciona para consultas que acessam os relacionamentos!
 * 
 * Por exemplo, veja o método abaixo onde estamos procurando funcionários 
 * pela descrição do cargo:
 * 
 * //deve estar no repositório do funcionário
 * List<Funcionario> findByCargoDescricao(String descricao);
 * 
 * Repare que usamos findBy para depois definir o caminho no relacionamento 
 * CargoDescricao (a descrição é um atributo dentro do Cargo). 
 * 
 * O método é análogo ao JPQL abaixo:
 * 
 * @Query("SELECT f FROM Funcionario f JOIN f.cargo c WHERE c.descricao = :descricao")
 * List<Funcionario> findByCargoPelaDescricao(String descricao);
 * 
 * Agora imagina se precisa pesquisar pela descrição mas da UnidadeTrabalho. 
 * A primeira ideia seria usar o nome findByUnidadeTrabalhosDescricao(String descricao) 
 * 
 * No entanto temos o problema que o nome da entidade UnidadeTrabalho 
 * é composto de duas palavras. Para separar claramente o nome da entidade do 
 * atributo devemos usar o caracter _. Veja a assinatura do método então:
 * 
 * List<Funcionario> findByUnidadeTrabalhos_Descricao(String descricao);
 * 
 * Também analisa a mesma pesquisa com JPQL e @Query:
 * 
 * @Query("SELECT f FROM Funcionario f JOIN f.unidadeTrabalhos u WHERE u.descricao = :descricao")
 * List<Funcionario> findByUnidadeTrabalhos_Descricao(String descricao);
 * 
 * Repare que nesse exemplo, bastante simples ainda, o nome do método já cresceu 
 * e usa uma nomenclatura fora do padrão Java. 
 * Isso é uma desvantagem dos Derived Query Methods.
 * 
 * Caso precise de consultas um pouco mais complexas, 
 * por exemplo usando relacionamentos e vários parâmetros, 
 * dê a preferência aos métodos com @Query para não prejudicar o entendimento 
 * pois os nomes dos métodos vão ficar muito longos para definir 
 * todos os critérios de busca. 
 */

/* Exemplos de derived queries: 
 * 
 * 
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
