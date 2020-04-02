package com.sebastardo.Etapa1;

/**
 *
 * @author Sebastian
 * 
 * 
 * Vagones dormitorio
 *
 * Para cada vagón dormitorio se indica: cuántos compartimientos tiene, y cuántas camas se ponen en cada compartimiento.
 * 
 * La cantidad máxima de pasajeros es el resultado de multiplicar cantidad de compartimientos por cantidad de camas por 
 *      compartimiento. P.ej. un vagón dormitorio con 12 compartimientos de 4 camas cada uno, puede llevar hasta 48 pasajeros.
 * 
 * Todos los vagones dormitorio tienen baños, y pueden llevar hasta 1200 kilos de carga cada uno.
 * 
 * Su peso máximo se calcula así: 4000 kilos, más 80 kilos por cada pasajero, más el máximo de carga que puede llevar.
 */

public class VagonDormitorio extends Vagon{

    public VagonDormitorio(int compartimientos, int camasEnCadaCompartimiento){
        super(0, true, 1200, 0);
        pasajeros = compartimientos * camasEnCadaCompartimiento;
        peso = 4000 + 80 * pasajeros + cargaMaxima;
    }
}
