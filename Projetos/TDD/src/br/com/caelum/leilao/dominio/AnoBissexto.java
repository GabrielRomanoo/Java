package br.com.caelum.leilao.dominio;

public class AnoBissexto {

	public boolean ehBissexto(int ano) {
		if (ano % 400 == 0) {
			return true;
		} else if (ano % 4 == 0 && ano % 100 != 0) {
			return true;
		}
		return false;
	}
}
