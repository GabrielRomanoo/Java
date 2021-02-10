package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.specification.SpecificationFuncionario;

@Service
public class RelatorioDinamicoFuncionario {
	
private final FuncionarioRepository funcionarioRepository;
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public RelatorioDinamicoFuncionario(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		System.out.println("Digite o nome do funcionario");
		String nome = scanner.next();
		
		// se o usuario nao quiser usar o campo como filtro na busca, ele digita null
		if (nome.equalsIgnoreCase("NULL")) {
			nome = null;
		}
		
		System.out.println("Digite o cpf do funcionario");
		String cpf = scanner.next();
		
		if (cpf.equalsIgnoreCase("NULL")) {
			cpf = null;
		}
		
		System.out.println("Digite o salrio do funcionario");
		Double salario = scanner.nextDouble();
		
		if (salario == 0){
			salario = null;
		}
		
		System.out.println("Digite a data de contratacao do funcionario");
		String data = scanner.next();
		
		LocalDate dataContratacao;
		if (data.equalsIgnoreCase("NULL")){
			dataContratacao = null;
		} else {
			dataContratacao = LocalDate.parse(data, formatter);
		}
		
			
		
		List<Funcionario> funcionarios = funcionarioRepository.findAll(
				Specification.where(SpecificationFuncionario.nome(nome))
				.or(Specification.where(SpecificationFuncionario.cpf(cpf)))		
				.or(Specification.where(SpecificationFuncionario.salario(salario)))	
				.or(Specification.where(SpecificationFuncionario.dataContratacao(dataContratacao)))	
				);
		
		funcionarios.forEach(System.out::println);
		
	}
}
/* Quando criamos consultas dinâmicas, utilizamos a Specification. Qual é o seu papel na criação das consultas dinâmicas?
		
		Ter um objeto com todos os itens necessários para realizar uma consulta dinâmica, como por exemplo root, criteriaQuery e criteriaBuilder.

		O objetivo é entregar, ao desenvolver um objeto pronto, para que ele só tenha que se preocupar com qual operação SQL ele deseja executar. */
