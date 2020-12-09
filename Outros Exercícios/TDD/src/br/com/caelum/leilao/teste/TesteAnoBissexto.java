package br.com.caelum.leilao.teste;

import org.junit.jupiter.api.Test;

import br.com.caelum.leilao.dominio.AnoBissexto;
import static org.junit.Assert.assertEquals;

public class TesteAnoBissexto {
	
	@Test
	public void deveRetornarAnoBissexto() {        
	    AnoBissexto anoBissexto = new AnoBissexto();

	    assertEquals(true, anoBissexto.ehBissexto(2016));
	    assertEquals(true, anoBissexto.ehBissexto(2012));

	}

	@Test
	public void naoDeveRetornarAnoBissexto() {        
	    AnoBissexto anoBissexto = new AnoBissexto();        

	    assertEquals(false, anoBissexto.ehBissexto(2015));
	    assertEquals(false, anoBissexto.ehBissexto(2011));
	}

}
