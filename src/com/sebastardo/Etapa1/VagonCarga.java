package com.sebastardo.Etapa1;

/**
 *
 * @author Sebastian
 * 
 * Para cada vagón de carga se indica su carga máxima ideal, y cuántas maderas tiene sueltas.
 * Un vagón de carga puede llevar hasta su carga máxima ideal, menos 400 kilos por cada madera suelta.
 * 
 * P.ej. un vagón de carga con carga máxima ideal 8000 kilos con 5 maderas sueltas puede llevar hasta 6000 kilos; 
 *      si cambiamos la cantidad de maderas sueltas a 2, entonces puede llevar hasta 7200 kilos.
 * 
 * No puede llevar pasajeros, y no tiene baños.
 * 
 * Su peso máximo es de 1500 kilos más el máximo de carga que puede llevar.
 * 
 * 
 */
public class VagonCarga extends Vagon{
    private int maderasSueltas;
    public VagonCarga(int cargaMaximaIdeal, int maderasSueltas){
        super(0, false, 0, 0);
        this.cargaMaxima = cargaMaximaIdeal - 400 * maderasSueltas;
        this.peso = 1500 + cargaMaxima;
        this.maderasSueltas = maderasSueltas;
    }    

    public int getMaderasSueltas() {
        return maderasSueltas;
    }

    public void setMaderasSueltas(int maderasSueltas) {
        this.maderasSueltas = maderasSueltas;
    }
    
    
}
