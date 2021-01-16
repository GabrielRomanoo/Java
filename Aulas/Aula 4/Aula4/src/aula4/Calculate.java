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
public class Calculate {
    
    public static final double PI = 3.14159;
    
    //essa classe nao tem atributos, apenas metodos estaticos
    //viu estatico na frente,esquece p.o. é imperativo, como o c
    public static int cube(int x) {
        return x*x*x;
    }
    
    public static double calcularArea(double R) {
        return PI*R*R;
    }
    
    public static double calcularPerimetro(double R) {
        return 2*PI*R;
    }
}
