package br.com.alura;

import java.util.Collections;
import java.util.Set;

public class TesteEmptySet {

	public static void main(String[] args) {
		Set<String> nomes = Collections.emptySet();
        nomes.add("Paulo"); //o que acontece aqui?
        
        /*
         * Recebemos a mesma exce��o: UnsupportedOperationException
         * Um conjunto destinado a ser vazio n�o pode ter um elemento, certo? 
         * Ent�o faz sentido receber essa exce��o. 
         * Mas para que um conjunto vazio poderia ser �til?
         * Por exemplo, imagina que voc� precisa representar um curso que 
         * foi cancelado pois n�o teve matriculas. Nesse caso faria todo sentido 
         * devolver um Collections.emptySet()
         */

	}

}
