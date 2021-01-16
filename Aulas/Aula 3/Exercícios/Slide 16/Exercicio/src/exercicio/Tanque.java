/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio;

/**
 *
 * @author CEITELABINFO
 */
public class Tanque {
    
    private float volumeMax;
    private float volumeAtual;
    private float volumeMinimo;
    private boolean bomba = true ;
    
    //abaixo é o construtor, que nao é usado, nem precisaria bota, pq ja tem os gets e sets
    /*
    public Tanque() {
        
    }
    */

    public float getVolumeMax() {
        return volumeMax;
    }

    public void setVolumeMax(float volumeMax) {
        this.volumeMax = volumeMax;
    }

    public float getVolumeAtual() {
        return volumeAtual;
    }


    public float getVolumeMinimo() {
        return volumeMinimo;
    }

    public void setVolumeMinimo(float volumeMinimo) {
        this.volumeMinimo = volumeMinimo;
    }

    public boolean isBomba() {
        return bomba;
    }

    public void setBomba(boolean bomba) {
        this.bomba = bomba;
    }
    
    //metodo encher[
    public void encher(float litros) {
        this.volumeAtual += litros;
        if (this.volumeAtual >= this.volumeMax) {
            this.volumeAtual = this.volumeMax;
            this.setBomba(false);
        }
    }
    
    //metodo esvaziar
    public void esvaziar(float litros) {
        this.volumeAtual -= litros;
        if (this.volumeAtual <= this.volumeMinimo) {
            this.volumeAtual = this.volumeMinimo;
            this.setBomba(true);
        }
    }
    
    //metodo exibir
    public String exibirInfos() {
        if (this.isBomba() == true) {
            return "Bomba esta Ligada, e o Volume Atual é: "+ this.getVolumeAtual();
        }
        else {
             return "Bomba esta Desligada, e o Volume Atual é: "+ this.getVolumeAtual();
        }
    }
    
  
    
    
    
    
}
