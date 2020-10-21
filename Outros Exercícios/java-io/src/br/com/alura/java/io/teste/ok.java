package br.com.alura.java.io.teste;


import java.time.Duration;
import java.util.Scanner;

public class ok {
	
    public static void main(String[] args) {
    	String T = "7500";
    	Integer tempo = Integer.valueOf(T);
    	System.out.println(tempo);
    	long input = tempo;
        Duration duracao =  Duration.ofSeconds(input);
        long horas = duracao.toHours();
        long minutos = duracao.minusHours(horas).toMinutes();
        long segundos = duracao.minusHours(horas).minusMinutes(minutos).getSeconds();
        //System.out.printf(horas + "h" + minutos + "m" + segundos + "s");
        T = String.valueOf(horas);
        T = T.concat("h");
        T = T.concat(String.valueOf(minutos));
        T.concat("m");
        T = T.concat(String.valueOf(segundos));
        T.concat("s");
        
    }
}