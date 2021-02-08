package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudFuncionarioService {

	private boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final FuncionarioRepository funcionarioRepository;
	private final CargoRepository cargoRepository;
	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	
	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository,
			 CargoRepository cargoRepository, UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.funcionarioRepository = funcionarioRepository;
		this.cargoRepository = cargoRepository;
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}
	
	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao de funcionario deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");
			
			int action = scanner.nextInt();

			switch (action) {
			case 1:
				salvar(scanner);
				
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false;
				break;
			}

		}
	}

	private void deletar(Scanner scanner) {
		System.out.println("Digite o id do funcionario");
		int id = scanner.nextInt();
		funcionarioRepository.deleteById(id);
		System.out.println("Deletado");
	}

	private void visualizar() {
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Digite o id");
		Integer id = scanner.nextInt();
		
		System.out.println("Digite o nome");
		String nome = scanner.next();
		
		System.out.println("Digite o cpf");
		String cpf = scanner.next();
		
		System.out.println("Digite o salario");
		Double salario = scanner.nextDouble();
		
		System.out.println("Digite a data de contratacao");
		String data = scanner.next();
		
		System.out.println("Digite o cargoId");
		Integer cargoId = scanner.nextInt();
		
		List<UnidadeTrabalho> unidades = unidades(scanner);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setDataContratacao(LocalDate.parse(data, formatter));
		funcionario.setCargo(cargoRepository.findById(cargoId).get());
		funcionario.setUnidadeTrabalhos(unidades);
		
		funcionarioRepository.save(funcionario);
		System.out.println("Atualizado");	
		
	}

	private void salvar(Scanner scanner) {
		System.out.println("Digite o nome");
		String nome = scanner.next();
		
		System.out.println("Digite o cpf");
		String cpf = scanner.next();
		
		System.out.println("Digite o salario");
		Double salario = scanner.nextDouble();
		
		System.out.println("Digite a data de contratacao");
		String data = scanner.next();
		
		System.out.println("Digite o cargoId");
		Integer cargoId = scanner.nextInt();
		
		List<UnidadeTrabalho> unidades = unidades(scanner);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setDataContratacao(LocalDate.parse(data, formatter));
		funcionario.setCargo(cargoRepository.findById(cargoId).get());
		funcionario.setUnidadeTrabalhos(unidades);
		
		funcionarioRepository.save(funcionario);
		System.out.println("Salvo");		
	}
	
	public List<UnidadeTrabalho> unidades(Scanner scanner) {
		
		boolean isTrue = true;
		List<UnidadeTrabalho> unidades = new ArrayList<UnidadeTrabalho>();
		
		while (isTrue) {
			System.out.println("Digite o unidadeId (Para sair digite 0)");
			Integer unidadeId = scanner.nextInt();
			
			if (unidadeId != 0) {
				unidades.add(unidadeTrabalhoRepository.findById(unidadeId).get());
			} else {
				isTrue = false;
			}
		}
		
		return unidades;
	}
}
