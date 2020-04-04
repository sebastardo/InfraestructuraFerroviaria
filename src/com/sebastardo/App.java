/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastardo;

import com.sebastardo.Etapa1.VagonPasajeros;

/**
 *
 * @author Sebastian
 */
public class App {
    public static void main(String[] args) {
        VagonPasajeros x = new VagonPasajeros(10,5, true, true);
        VagonPasajeros y = new VagonPasajeros(31,5, true, true);
        Formacion tren = new Formacion();
        
        tren.agregar(x);
        tren.agregar(y);
        
        System.out.println(x.toString());
        System.out.println(y.toString());
        
        tren.organizada();
    }
}
