/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastardo.Etapa2;

/**
 *
 * @author Sebastian
 * 
 * Agregar al modelo las locomotoras. De cada locomotora debe indicarse: su peso, hasta cuánto peso puede arrastar, y su velocidad máxima. 
 *  Decimos que una locomotora es eficiente si puede arrastrar, al menos, cinco veces su peso. P.ej. una locomotora que pesa 1000 kilos y 
 *  puede arrastar hasta 7000 es eficiente; si puede arrastrar hasta 3000 entonces no es eficiente.
 * 
 * Ahora una formación incluye locomotoras (pueden ser varias), además de vagones.
 * 
 * Con el modelo ampliado, tiene que poder obtenerse fácilmente, para una formación:
 * 
 *     su velocidad máxima , que es el mínimo entre las velocidades máximas de las locomotoras.
 *     Si es eficiente; o sea, si todas sus locomotoras lo son.
 *     Si puede moverse. Una formación puede moverse si la suma del arrastre de cada una de sus locomotoras, es mayor o igual al peso máximo 
 *      de la formación, que es: peso de las locomotoras + peso máximo de los vagones.
 *     Cuántos kilos de empuje le faltan para poder moverse, que es: 0 si ya se puede mover, y si no, el resultado de: peso máximo - suma de 
 *      arrastre de cada locomotora.
 * 
 * P.ej. si una formación tiene una locomotora que pesa 1000 kilos y arrastra hasta 30000, y cuatro vagones, de 6000 kilos de peso máximo cada 
 *  uno, entonces sí puede moverse, porque su peso máximo es 25000.
 * Si agregamos dos vagones más de 6000 kilos, llevamos el peso máximo a 37000. Ahora la formación no puede moverse y le faltan 7000 kilos de empuje.
 * 
 * 
 */
public class Locomotora {
    private int peso;
    private int pesoArrastre;
    private int velocidadMaxima;

    public Locomotora(int peso, int pesoArrastre, int velocidadMaxima) {
        this.peso = peso;
        this.pesoArrastre = pesoArrastre;
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getPeso() {
        return peso;
    }

    public int getPesoArrastre() {
        return pesoArrastre;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }
    
     public boolean esEficiente(){
        return pesoArrastre>=5*peso;
    }
        
}
