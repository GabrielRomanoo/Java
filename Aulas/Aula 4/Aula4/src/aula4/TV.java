/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4;

/**
 *
 * @author CEITELABINFO
 */
public class TV {
    
    public int canal = 0;
    public int volume = 0;
    public static String bateria = "standby";
    
    public static final byte liga_TV = 1;
    public static final byte desliga_TV = 2;
    public static final byte aumenta_Canal = 3;
    public static final byte diminui_Canal = 4;
    public static final byte aumenta_Volume = 5;
    public static final byte diminui_Volume = 6;
    
    public static void ligarControle() {
        bateria = "normal";
    }
    
    public static void enviar(byte x) {
        System.out.println("Sinal enviado...: "+ x);
        if (x == desliga_TV) {
            bateria = "standby";
        }
    }
    
}
