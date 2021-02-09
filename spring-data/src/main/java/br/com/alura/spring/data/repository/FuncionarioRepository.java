package br.com.alura.spring.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

	//Derived Query (query's geradas pelo framework spring, ver a documentacao para ver as variacoes: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)
	List<Funcionario> findByNome(String nome);
}
