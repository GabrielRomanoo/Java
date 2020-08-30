package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;
import br.com.bytebank.banco.modelo.SaldoException;

public class TesteContas {

	public static void main(String[] args) throws SaldoException {
		
		/*
		 * NOME PACOTE + CLASSE = modelo.ContaCorrente
		 * se chama Full Qualified Name (FQN) 
		 * ContaCorrente é apenas o Single Name
		*/
		
		ContaCorrente cc = new ContaCorrente(111, 111);
		cc.deposita(100.0);
		
		//digita cp e aperta (ctrl + espaço) para auto completar
		ContaPoupanca cp = new ContaPoupanca(222, 222);
		cp.deposita(200.0);

		cc.transfere(10.0, cp);
		
		System.out.println("CC: "+cc.getSaldo());
		System.out.println("CP: "+cp.getSaldo());
		
		System.out.println(cc);
	}

}
