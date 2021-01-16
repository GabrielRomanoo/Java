
public class TestaConversao {

	public static void main(String[] args) {
		
		//float numero = 3.14;
		/* a linha acima irá dar erro
		 * para o Java, 3.14 é um double. 
		 * é o mesmo problema que tem quando tentamos guardar 
		 * um double dentro de um int . 
		 * Em um tipo double podemos armazenar 64 bits, 
		 * no float e no int apenas 32 bits. 
		 * Isso pode acarretar em perda de informação, para que esse código funcione, 
		 * podemos fazer o casting, colocando (float) na frente de 3.14, 
		 * mas faremos de uma outra forma.
		 */
		
		/* o JAVA considera todos os numeros double, então...
		 * devemos corrigir como: float numero = (float) 3.14; //casting
		 * ou: float numero = 3.14f;
		 * usa-se mais ou double para declarar
		 */
		
		double salario = 1270.50;
		int valor = (int) salario; //casting (transforma o double em int)
		System.out.println(valor);
		
		/*
		 * para variaveis primitivas, o casting faz com que a conversão
		 * seja feita de uma maneira automática
		 */
		
		//int cabe 32bits, pode guardar até 2 bilhões
		//long cabe 64bits, tem que botar um l no final para poder compilar
		//short guarda 16bits
		
		double valor1 = 0.2;
		double valor2 = 0.1;
		double total = valor1 + valor2;
		
		System.out.println(total);
		
		/*
		 * repare que não irá imprimir 0.3, e sim 0.30000000000000004
		 * isso é um erro que acontece em diversas linguagens 
		 * ou seja, para guardar salários, por exemplo, 
		 * a variável double não é indicada por conta disso
		 */
	
		
		
	}
	

}
