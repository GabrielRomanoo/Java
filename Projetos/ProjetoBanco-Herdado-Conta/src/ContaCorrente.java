
public class ContaCorrente extends Conta implements Tributavel{
	
	//o java tenta chamar implicitamente o construtor padrao da classe pai, 
	//no entanto, nao temos esse contrutor l�
	
	/*
	 * CONSTRUTORES NAO SAO HERDADOS
	 * 
	 * A partir do momento em que voc� escreve um construtor na 
	 * classe m�e o construtor padr�o (default) deixa de existir.
	 * 
	 * Logo, quando voc� escreve a classe filha sem um construtor, 
	 * o construtor padr�o � chamado implicitamente por debaixo dos panos.
	 * 
	 * E temos que ter um construtor na classe filha que realmente invoque 
	 * algum construtor existente na classe m�e.
	 * 
	 * Se na classe m�e, nao tiver nenhum construtor default, ser� preciso 
	 * invocar um construtor espec�fico da classe mae pela classe filha.
	 */
	
	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero); //chamando o construtor especifico da classe mae
	}
	
	/*
	 * voc� pode usar o @Override para garantir que, 
	 * caso voc� mude a assinatura do metodoExemplo() na classe m�e,
	 * esse mesmo m�todo pare de funcionar na classe filha tamb�m, 
	 * te obrigando a corrigir a o c�digo.
	 * 
	 * ele garante que o m�todo que ser� sobrescrito realmente existe na classe m�e.
	 */
	//Override indica para o compilador que estamos sobrescrevendo um metodo
	//� usada para sobrescrever o m�todo da classe m�e, indicando que o m�todo original foi alterado.
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
