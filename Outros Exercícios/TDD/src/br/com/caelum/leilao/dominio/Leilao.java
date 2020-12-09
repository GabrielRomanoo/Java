package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;

	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		int total = qtdDeLancesDo(lance.getUsuario());

		if (this.lances.isEmpty() || podeDarLance(lance.getUsuario())) {
			lances.add(lance); //usou o equals acima, entao precisa implementar na classe Usuario
		}
	}

	private boolean podeDarLance(Usuario usuario) {
		return !ultimoLanceDado().getUsuario().equals(usuario) && qtdDeLancesDo(usuario) < 5;
	}

	private int qtdDeLancesDo(Usuario usuario) {
		int total = 0;
		for (Lance l : lances) {
			if (l.getUsuario().equals(usuario)) total++;
		}
		return total;
	}

	private Lance ultimoLanceDado() {
		return this.lances.get(this.lances.size()-1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public void dobraLance(Usuario usuario) {
		if (!lances.isEmpty()) {
			double valor = ultimoLanceDo(usuario);
			lances.add(new Lance(usuario, (valor * 2)));
		}
	}

	private double ultimoLanceDo(Usuario usuario) {
		double valor = 0;
		for (Lance lance : lances) {
			if (lance.getUsuario().getNome().equals(usuario.getNome())) {
				valor = lance.getValor();
			}
		}
		return valor;
	}
}
