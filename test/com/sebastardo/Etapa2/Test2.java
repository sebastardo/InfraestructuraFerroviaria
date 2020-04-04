/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastardo.Etapa2;

import com.sebastardo.Etapa1.VagonCarga;
import com.sebastardo.Etapa1.VagonDormitorio;
import com.sebastardo.Etapa1.VagonPasajeros;
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
public class Test2 {
    
    static Formacion tren;
    
    static Locomotora l1;
    static Locomotora l2;
    
    static VagonPasajeros p1;
    static VagonPasajeros p2;
    static VagonCarga c;
    static VagonDormitorio d;
    
    public Test2() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        tren = new Formacion();
        
        p1 = new VagonPasajeros(10,4, true, true);
        p2 = new VagonPasajeros(7,2, false, false);
        c = new VagonCarga(6800,5);
        d = new VagonDormitorio(8,3);
        

        l1 = new Locomotora(3000, 20000,0);
        l2 = new Locomotora(5000, 22000,0);
        
        tren.agregar(p1);
        tren.agregar(p2);
        tren.agregar(c);
        tren.agregar(d);
        
        tren.agregar(l1);
        tren.agregar(l2);
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

    // 1 - Si a la formación le agregamos la locomotora 1, entonces, es eficiente, no puede moverse, y le faltan 12800 kg de empuje.
    // 2 - Si a la misma formación le agregamos también la locomotora 2, entonces no es eficiente, sí puede moverse, y le faltan 0 kilos de empuje.
    @Test
    public void TestEsEficiente(){
        //1
        //assertTrue(tren.esEficiente());
        
        // 2
        assertFalse(tren.esEficiente());
    }
    
    @Test
    public void TestPuedeMoverse(){
        //1
        //assertFalse(tren.puedeMoverse());
        
        // 2
        assertTrue(tren.puedeMoverse());
    }
    
    @Test
    public void TestKilosDeEmpuje(){
        int resultado = tren.kilosDeEmpuje();
        
        //1
        //int esperado = 12800;
        
        // 2
        int esperado = 0;
        
        assertEquals(esperado, resultado);
    }
}
