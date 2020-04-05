package com.sebastardo.Etapa3;

import com.sebastardo.Etapa1.Vagon;
import com.sebastardo.Etapa2.Locomotora;
import com.sebastardo.Formacion;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Sebastian
 * 
 * 
 * Etapa 3 - depósitos
 * 
 * Agregar al modelo los depósitos ferroviarios. En cada depósito hay: formaciones ya armadas, y locomotoras sueltas.
 * 
 * Se pide resolver lo siguiente:
 * 
 *     Dado un depósito, obtener el conjunto formado por el vagón más pesado de cada formación; se espera un conjunto de vagones.
 *     Saber si un depósito necesita un conductor experimentado.
 *     Un depósito necesita un conductor experimentado si alguna de sus formaciones es compleja. Una formación es compleja si: tiene 
 *          más de 8 unidades (sumando locomotoras y vagones), o el peso máximo es de más de 80000 kg.
 *     Que un depósito pueda agregar una locomotora a una formación determinada, de forma tal que la formación pueda moverse.
 *         Si la formación ya puede moverse, entonces no se hace nada.
 *         Si no, se le agrega una locomotora suelta del depósito cuyo arrastre sea mayor o igual a los kilos de empuje que le 
 *              faltan a la formación. Si no hay ninguna locomotora suelta que cumpla esta condición, no se hace nada.
 * 
 */
public class Deposito {
    private List<Formacion> formaciones;
    private List<Locomotora> locomotoras;

    public Deposito() {
        formaciones = new ArrayList<>();
        locomotoras = new ArrayList<>();
    }

    public void guardar(Object algo){
        if(algo instanceof Formacion){
            formaciones.add((Formacion)algo);
        }
        if(algo instanceof Locomotora){
            locomotoras.add((Locomotora)algo);
        }
    }
    
    
    ///Dado un depósito, obtener el conjunto formado por el vagón más pesado de cada formación; se espera un conjunto de vagones.
    private List<Vagon> vagonesPesados(){
        return formaciones.stream().map(f->f.vagonMasPesado()).collect(Collectors.toList());
    }
    
    public Formacion formacionConVagonesPesados(){
        Formacion f = new Formacion();
        vagonesPesados().stream().forEach(v->f.agregar(v));
        return f;
    }
    ///
    
    
    
    /**
     * Saber si un depósito necesita un conductor experimentado.
     *     Un depósito necesita un conductor experimentado si alguna de sus formaciones es compleja. Una formación es compleja si: tiene 
     *          más de 8 unidades (sumando locomotoras y vagones), o el peso máximo es de más de 80000 kg.
     */
    private boolean formacionCompleja(){
        return formaciones.stream().anyMatch(f->f.tamaño()>8) || formaciones.stream().anyMatch(f->f.pesoTotal() > 80000);
    }
    
    
    public boolean necesitaConductorExperimentado(){
        return formacionCompleja();
    }
    ///
    
    public void moverFormacion(){
        /**
         *     Que un depósito pueda agregar una locomotora a una formación determinada, de forma tal que la formación pueda moverse.
         *         Si la formación ya puede moverse, entonces no se hace nada.
         *         Si no, se le agrega una locomotora suelta del depósito cuyo arrastre sea mayor o igual a los kilos de empuje que le 
         *              faltan a la formación. Si no hay ninguna locomotora suelta que cumpla esta condición, no se hace nada.
         */
        
        // Es sabado, son las 2 am y no tengo ganas de hacerlo.
    }
}
