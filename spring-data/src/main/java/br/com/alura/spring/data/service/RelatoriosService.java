package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {

	private boolean system = true;
	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionario nome");
			System.out.println("2 - Busca funcionario, data contratacao e salario maior");
	
			int action = scanner.nextInt();

			switch (action) {
			case 1:
				buscaFuncionarioPorNome(scanner);
				break;
			case 2:
				buscaFuncionarioNomeSalarioMaiorData(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}

	private void buscaFuncionarioPorNome(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar");
		String nome = scanner.next();
		List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);
		funcionarios.forEach(System.out::println);
	}
	
	private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar");
		String nome = scanner.next();
		System.out.println("Qual salario deseja pesquisar");
		Double salario = scanner.nextDouble();
		System.out.println("Qual data deseja pesquisar");
		String data = scanner.next();
		
		LocalDate dataFormatada = LocalDate.parse(data, formatter);
		
		List<Funcionario> funcionarios = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, dataFormatada);
		funcionarios.forEach(System.out::println);
	}
	
}
