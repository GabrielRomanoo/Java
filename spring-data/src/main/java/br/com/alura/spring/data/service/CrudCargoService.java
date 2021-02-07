package br.com.alura.spring.data.service;

import java.util.Scanner;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

public class CrudCargoService {

	private final CargoRepository repository;
	
	public CrudCargoService(CargoRepository repository) {
		this.repository = repository;
	}
	
	public void inicial(Scanner scanner) {
		salvar(scanner);
	}
	
	public void salvar(Scanner scanner) {
		System.out.println("Digite a descricao do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		repository.save(cargo);
	}
}
