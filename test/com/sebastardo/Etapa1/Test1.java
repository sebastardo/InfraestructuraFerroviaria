/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastardo.Etapa1;

import com.sebastardo.Formacion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sebastian
 */
public class Test1 {
    static Formacion tren;
    
    
    
    static VagonPasajeros p1;
    static VagonPasajeros p2;
    static VagonCarga c;
    static VagonDormitorio d;
    
    
    public Test1() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        tren = new Formacion();
        
        p1 = new VagonPasajeros(10,4, true, true);
        p2 = new VagonPasajeros(7,2, false, false);
        c = new VagonCarga(6800,5);
        d = new VagonDormitorio(8,3);
        
        tren.agregar(p1);
        tren.agregar(p2);
        tren.agregar(c);
        tren.agregar(d);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    
    @Test
    public void TestEquilibradaEnPasajeros(){
        assertFalse(tren.equilibradaEnPasajeros());
    }
}
