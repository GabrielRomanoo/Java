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
public class ConvertePI {
    
    //classe sem atributos;
    
    public static int converteInteiro(){
        Double d = Math.PI;
        return d.intValue();
    }
    
    public static String converteString(){
        return Double.toString(Math.PI);
    }
    
    public static float converteFloat(){
        Double d = Math.PI;
        return d.floatValue();
    }
    
    public static short converteShort(){
        Double d = Math.PI; //esse double n é primitivo, e sim uma classe
        return d.shortValue();
    }
    
    public static byte converteByte(){
        Double d = Math.PI;
        return d.byteValue();
    }
    
}
