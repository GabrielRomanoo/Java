/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula7;

/**
 *
 * @author CEITELABINFO
 */
public class Aula7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Arma a[] = new Arma[3];
        
        Revolver glock = new Revolver(60);
        LancaChama fx = new LancaChama(1000);
        Faca faquinha = new Faca(10);
        
        a[0] = glock;
        a[1] = fx;
        a[2] = faquinha;
        
        agredir(a);
        
        atirar(glock);
        atirar(fx);
        
        recarregar(glock);
        recarregar(fx);
        
        atirar(glock);
        atirar(fx);
        
        atirar(glock);
        atirar(fx);
        
        
        System.out.println("\nRevoler: destruicao..: "+glock.getDestruicao()+" e cartucho..: "+glock.getCartucho());
        System.out.println("Lança Chamas: destruicao..: "+fx.getDestruicao()+" e gas..: "+fx.getGas());
        System.out.println("Faca: destruicao..: "+faquinha.getDestruicao()+" e faca..: "+faquinha.getLamina());
        
        
    }
    
    private static void agredir(Arma a[]) {
        for (Arma x: a){
            x.golpear();
        }
    }
    
    private static void atirar(Disparavel d) {
         d.disparar();
         
    }
    
    private static void recarregar(Disparavel d) {
         d.recarregar();
    }
    
}
