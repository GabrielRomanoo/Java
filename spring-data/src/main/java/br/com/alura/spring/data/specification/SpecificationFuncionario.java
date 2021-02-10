package br.com.alura.spring.data.specification;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

public class SpecificationFuncionario {
	
	public static Specification<Funcionario> nome(String nome) { //o nome do método é 'nome' por causa do atributo 'nome' na classe/entidade 'Funcionário'
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
		//este metodo especifica que deve fazer uma consulta no banco de dados usando like, com o nome passado como parametro
	}
	
	public static Specification<Funcionario> cpf(String cpf) { //o nome do método é 'nome' por causa do atributo 'nome' na classe/entidade 'Funcionário'
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.equal(root.get("cpf"), cpf);
	}
	
	public static Specification<Funcionario> salario(Double salario) { //o nome do método é 'nome' por causa do atributo 'nome' na classe/entidade 'Funcionário'
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.greaterThan(root.get("salario"), salario);
		//este metodo especifica que deve fazer uma consulta no banco de dados usando like, com o nome passado como parametro
	}
	
	public static Specification<Funcionario> dataContratacao(LocalDate dataContratacao) { //o nome do método é 'nome' por causa do atributo 'nome' na classe/entidade 'Funcionário'
		return (root, criteriaQuery, criteriaBuilder) ->
			criteriaBuilder.greaterThanOrEqualTo(root.get("dataContratacao"), dataContratacao);
		//este metodo especifica que deve fazer uma consulta no banco de dados usando like, com o nome passado como parametro
	}

}
