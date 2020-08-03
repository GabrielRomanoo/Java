
public class TestePontoFlutuante {

	public static void main(String[] args) {

		double salario;
		salario = 600.00;
		System.out.println("meu salario é: " + salario);
		
		//estaticamente tipada
		double idade = 37;
		
		double divisao = 3.14 / 2; //o ideal é declarar e inicializar a variavel
		System.out.println(divisao);
		
		int outraDivisao = 5 / 2;
		System.out.println(outraDivisao); //vai truncar
		
		double novaTentativa = 5 / 2; //tinha que ter colocar 5 / 2.0 ou 5.0 / 2
		System.out.println(novaTentativa);
		

	}

}
