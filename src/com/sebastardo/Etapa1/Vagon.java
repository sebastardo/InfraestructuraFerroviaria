package com.sebastardo.Etapa1;

/**
 *
 * @author Sebastian
 */
public abstract class Vagon {
    protected int pasajeros;
    protected boolean baño;
    protected int cargaMaxima;
    protected int peso;

    protected Vagon(int pasajeros, boolean baño, int cargaMaxima, int peso) {
        this.pasajeros = pasajeros;
        this.baño = baño;
        this.cargaMaxima = cargaMaxima;
        this.peso = peso;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public boolean isBaño() {
        return baño;
    }

    public int getCargaMaxima() {
        return cargaMaxima;
    }

    public int getPeso() {
        return peso;
    } 
    
    
    

    @Override
    public String toString() {
        return "Vagon{" + "pasajeros=" + pasajeros + ", ba\u00f1o=" + baño + ", cargaMaxima=" + cargaMaxima + ", peso=" + peso + '}';
    }

}
