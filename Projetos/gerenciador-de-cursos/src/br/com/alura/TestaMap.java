package br.com.alura;

import java.util.HashMap;
import java.util.Map;

public class TestaMap {

    public static void main(String[] args) {

        Map<String, Integer> nomesParaIdade = new HashMap<>();
        nomesParaIdade.put("Paulo", 31);
        nomesParaIdade.put("Adriano", 25);
        nomesParaIdade.put("Alberto", 33);
        nomesParaIdade.put("Guilherme", 26);
        
//      iterando pelo keyset
        
    	nomesParaIdade.keySet().forEach(nome -> {
    		System.out.println(nome);
    	});
    	
//    	Set<String> chaves = nomesParaIdade.keySet();    
//    	for (String nome : chaves) {
//    	    System.out.println(nome);
//    	}
    	
//    	iterando pelo values
    	
    	nomesParaIdade.values().forEach(idade -> {
    		System.out.println(idade);
    	});
    	
//    	Collection<Integer> valores = nomesParaIdade.values();
//    	for (Integer idade : valores) {
//    	    System.out.println(idade);
//    	}
    	
    	/*
    	 * Agora s� falta a terceira cole��o que devolve a associa��o. 
    	 * Para tal, existe o m�todo entrySet() e cada associa��o � 
    	 * representado atrav�s da classe Entry:
    	 */
    	
//    	Set<Entry<String, Integer>> associacoes = nomesParaIdade.entrySet();
//
//    	for (Entry<String, Integer> associacao : associacoes) {
//    	    System.out.println(associacao.getKey() + " - " + associacao.getValue());
//    	}
//		
    	
    	/* OU */
    	 nomesParaIdade.entrySet().forEach(associacao -> {
             System.out.println(associacao);
         });
    }
}