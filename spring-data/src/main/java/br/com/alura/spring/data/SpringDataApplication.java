package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.alura.spring.data.service.RelatorioDinamicoFuncionario;
import br.com.alura.spring.data.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatoriosService relatoriosService;
	private final RelatorioDinamicoFuncionario relatorioDinamicoFuncionario;

	
	private Boolean system = true;
	
	public SpringDataApplication(CrudCargoService cargoService
			, CrudFuncionarioService funcionarioService
			, CrudUnidadeTrabalhoService unidadeTrabalhoService
			, RelatoriosService relatoriosService
			, RelatorioDinamicoFuncionario relatorioDinamicoFuncionario
			) {
			
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatoriosService = relatoriosService;
		this.relatorioDinamicoFuncionario = relatorioDinamicoFuncionario;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args); //essa linha faz com que o framework do Spring seja inicializado junto a nossa aplicação
	}

	@Override //apos o fim do metodo main, esse metodo sera rodado
	public void run(String... args) throws Exception {
		
		/* Pegando os dados do usuario */
		Scanner scanner = new Scanner(System.in);
		
		while (system) {
			System.out.println("Qual acao voce quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade Trabalho");
			System.out.println("4 - Relatorios");
			System.out.println("5 - Relatorios Dinamicos");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				cargoService.inicial(scanner);
				break;
			case 2:
				funcionarioService.inicial(scanner);
				break;
			case 3:
				unidadeTrabalhoService.inicial(scanner);
				break;
			case 4:
				relatoriosService.inicial(scanner);
				break;
			case 5:
				relatorioDinamicoFuncionario.inicial(scanner);
				break;
			default:
				system = false;
				break;
			}
			
			
		}
	}

}
