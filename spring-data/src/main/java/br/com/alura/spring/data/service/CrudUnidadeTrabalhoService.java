package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {

	private boolean system = true;
	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao de cargo deseja executar");
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
		System.out.println("Digite o id da unidade");
		int id = scanner.nextInt();
		
		unidadeTrabalhoRepository.deleteById(id);
		
		System.out.println("Deletado");
	}

	private void visualizar() {
		Iterable<UnidadeTrabalho> unidades = unidadeTrabalhoRepository.findAll();
		unidades.forEach(unidade -> System.out.println(unidade));
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Digite o id da unidade");
		int id = scanner.nextInt();
		System.out.println("Digite a nova descricao da unidade");
		String descricao = scanner.next();
		System.out.println("Digite o novo endereco da unidade");
		String endereco = scanner.next();

		UnidadeTrabalho unidade = new UnidadeTrabalho();
		unidade.setId(id);
		unidade.setDescricao(descricao);
		unidade.setEndereco(endereco);
		unidadeTrabalhoRepository.save(unidade); // o metodo save quando informado o id, ele atualiza o registro

		System.out.println("Atualizado");
	}

	private void salvar(Scanner scanner) {
		System.out.println("Digite a descricao da unidade");
		String descricao = scanner.next();
		System.out.println("Digite o endereco da unidade");
		String endereco = scanner.next();

		UnidadeTrabalho unidade = new UnidadeTrabalho();
		unidade.setDescricao(descricao);
		unidade.setEndereco(endereco);
		unidadeTrabalhoRepository.save(unidade);

		System.out.println("Salvo");
	}
}
