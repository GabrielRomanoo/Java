package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY; // menor numero que cabe em um Double
	private double menorDeTodos = Double.POSITIVE_INFINITY; // maior numero que cabe em um Double
	private double media;
	private List<Lance> maiores = Collections.emptyList();

	public void avalia(Leilao leilao) {
		if (leilao.getLances().isEmpty()) {
			media = 0;
		} else {
			maiorDeTodos = Collections.max(leilao.getLances(), Comparator.comparing(Lance::getValor)).getValor();
			menorDeTodos = Collections.min(leilao.getLances(), Comparator.comparing(Lance::getValor)).getValor();
			media = leilao.getLances().stream().mapToDouble(Lance::getValor).average().getAsDouble();
			pegaOsMaioresNo(leilao);
		}
	}

	private void pegaOsMaioresNo(Leilao leilao) {
		maiores = new ArrayList<Lance>(leilao.getLances());
		maiores.sort((s1, s2) -> {
			if (s1.getValor() < s2.getValor()) {
				return 1;
			}
			if (s1.getValor() > s2.getValor()) {
				return -1;
			}
			return 0;
		});
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size()); // verificamos se o tamnho da lista é
																				// menor do que 3, para evitar
																				// exception
	}
	
	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return menorDeTodos;
	}

	public double getMedia() {
		return media;
	}

	public List<Lance> getTresMaiores() {
		return maiores;
	}
}
