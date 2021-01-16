
public class ContaCorrente extends Conta implements Tributavel{
	
	//o java tenta chamar implicitamente o construtor padrao da classe pai, 
	//no entanto, nao temos esse contrutor lá
	
	/*
	 * CONSTRUTORES NAO SAO HERDADOS
	 * 
	 * A partir do momento em que você escreve um construtor na 
	 * classe mãe o construtor padrão (default) deixa de existir.
	 * 
	 * Logo, quando você escreve a classe filha sem um construtor, 
	 * o construtor padrão é chamado implicitamente por debaixo dos panos.
	 * 
	 * E temos que ter um construtor na classe filha que realmente invoque 
	 * algum construtor existente na classe mãe.
	 * 
	 * Se na classe mãe, nao tiver nenhum construtor default, será preciso 
	 * invocar um construtor específico da classe mae pela classe filha.
	 */
	
	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero); //chamando o construtor especifico da classe mae
	}
	
	/*
	 * você pode usar o @Override para garantir que, 
	 * caso você mude a assinatura do metodoExemplo() na classe mãe,
	 * esse mesmo método pare de funcionar na classe filha também, 
	 * te obrigando a corrigir a o código.
	 * 
	 * ele garante que o método que será sobrescrito realmente existe na classe mãe.
	 */
	//Override indica para o compilador que estamos sobrescrevendo um metodo
	//É usada para sobrescrever o método da classe mãe, indicando que o método original foi alterado.
	@Override 
	public boolean saca(double valor) {
		double valorASacar = valor + 0.20;
		return super.saca(valorASacar);
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;
	}

	@Override
	public double getValorImposto() {
		return super.saldo * 0.01;
	}
}
