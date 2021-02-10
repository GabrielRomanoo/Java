package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
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
			System.out.println("3 - Busca funcionario, data contratacao maior");
			System.out.println("4 - Busca funcionario salario");
			
			int action = scanner.nextInt();

			switch (action) {
			case 1:
				buscaFuncionarioPorNome(scanner);
				break;
			case 2:
				buscaFuncionarioNomeSalarioMaiorData(scanner);
				break;
			case 3:
				buscaFuncionarioDataContratacaoMaior(scanner);
				break;
			case 4:
				pesquisaFuncionarioSalario();
				break;
			default:
				system = false;
				break;
			}
		}
	}

	private void buscaFuncionarioDataContratacaoMaior(Scanner scanner) {
				System.out.println("Qual data deseja pesquisar");
		String data = scanner.next();
		
		LocalDate dataFormatada = LocalDate.parse(data, formatter);
		
		List<Funcionario> funcionarios = funcionarioRepository.findDataContratacaoMaior(dataFormatada);
		funcionarios.forEach(System.out::println);
		
		//busca os funcionarios contratados depois da data informada
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
	
	private void pesquisaFuncionarioSalario() {
		List<FuncionarioProjecao> funcionarios = funcionarioRepository.findFuncionarioSalario();
		funcionarios.forEach(f -> System.out.println(
				"Funcionario: id: " + f.getId()
				+ " | nome: " + f.getNome() + "| salario: " + f.getSalario()
				));
	}
	
}
