package com.sebastardo.Etapa1;

/**
 *
 * @author Sebastian
 * 
 * Vagones de pasajeros
 * 
 *  Para definir un vagón de pasajeros, debemos indicar el largo y el ancho medidos en metros, si tiene o no baños, y si está o no ordenado.
 *
 *  A partir de estos valores, la cantidad de pasajeros que puede transportar un vagón se calcula de esta forma:
 *
 *      si el ancho es hasta 3 metros, entran 8 pasajeros por cada metro de largo.
 *      si el ancho es de más de 3 metros, entran 10 pasajeros por cada metro de largo.
 *
 *  Si el vagón no está ordenado, restar 15 pasajeros.
 *
 *  P.ej.:
 *
 *      un vagón de pasajeros de 10 metros de largo y 2 de ancho puede llevar hasta 80 pasajeros si está ordenado, 65 pasajeros si no.
 *      otro vagón, también de 10 metros de largo, pero de 4 metros de ancho, puede llevar hasta 100 pasajeros si está ordenado, 85 pasajeros si no.
 *
 *  La cantidad máxima de carga que puede llevar un vagón de pasajeros depende de si tiene o no baños:
 *
 *      si tiene baños, entonces puede llevar hasta 300 kilos.
 *      si no, hasta 800 kilos.
 *
 *  El peso máximo de un vagón de pasajeros se calcula así: 2000 kilos, más 80 kilos por cada pasajero, más el máximo de carga que puede llevar.
 * 
 */
public class VagonPasajeros extends Vagon{
    
    private boolean ordenado;

    public VagonPasajeros(int largo, int ancho, boolean baño, boolean ordenado){
        super(ancho<=3?8*largo:10*largo, baño, baño?300:800, 0);
        if(!ordenado)
           this.pasajeros -= 15;       
        this.peso = 2000 + pasajeros*80 + cargaMaxima;
        this.ordenado = ordenado;
    }

    public boolean isOrdenado() {
        return ordenado;
    }

    public void setOrdenado(boolean ordenado) {
        this.ordenado = ordenado;
    }
}
