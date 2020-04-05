package com.sebastardo;

import com.sebastardo.Etapa1.Vagon;
import com.sebastardo.Etapa1.VagonCarga;
import com.sebastardo.Etapa1.VagonPasajeros;
import com.sebastardo.Etapa2.Locomotora;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Sebastian
 * 
 * Requerimientos - información sobre una formación
 * 
 * A partir del modelo que se construya se tiene que poder saber fácilmente, para una formación:
 * 
 *     hasta cuántos pasajeros puede llevar.
 *     cuántos vagones populares tiene. Un vagón es popular si puede llevar más de 50 pasajeros.
 *     si es una formación carguera, o sea, si todos los vagones pueden transportar al menos 1000 kilos de carga.
 *     cuál es la dispersión de pesos, que es el resultado de esta cuenta: peso máximo del vagón más pesado - peso máximo del vagón más liviano. 
 *          P.ej. si una formación tiene 4 vagones, cuyos pesos máximos son 9000, 12000, 3500 y 8000, entonces su dispersión de pesos es 12000 - 3500 = 8500.
 *     cuántos baños tiene una formación, que se obtiene como la cantidad de vagones que tienen baños (se supone que cada vagón que tiene baños, tiene uno solo).
 * 
 * Además, se tiene que poder hacer mantenimiento de una formación, que implica hacer mantenimiento de cada vagón, de acuerdo a estas definiciones
 * 
 *     hacer mantenimiento de un vagón de pasajeros quiere decir ordenarlo; si no estaba ordenado pasa a estar ordenado, si ya estaba ordenado no cambia nada.
 *     hacer mantenimiento de un vagón de carga es arreglar dos de las maderas que tiene sueltas: si tenía 5 pasa a 3, si tenía 1 pasa a 0, si tenía 0 queda en 0.
 *     hacer mantenimiento de un vagón dormitorio no tiene ningún efecto que interese para este modelo.
 * 
 * 
 * Un poco más salados
 * 
 * Poder pedirle a una formación lo siguiente:
 * 
 *     si está equilbrada en pasajeros, o sea: si considerando sólo los vagones que llevan pasajeros, la diferencia entre el que más lleva y el que menos 
 *          no supera los 20 pasajeros.
 *     si está organizada, o sea: adelante los vagones que llevan pasajeros, y atrás los que no. Para esto, los vagones se tienen que almacenar en una lista. 
 *          Si agregamos dos vagones que llevan pasajeros, uno que no, y después uno que sí, entonces la formación no está organizada.
 *     ¡Ojo! si todos los vagones de la formación llevan pasajeros, o si ninguno lleva, entonces la formación sí se considera organizada.
 * 
 */
public class Formacion {
    private List<Vagon> tren;
    private List<Locomotora> maquina;
    
    public Formacion(){
        tren = new ArrayList<>();
        maquina = new ArrayList<>();
    }
    
    public void agregar(Object v){
        if(v instanceof Vagon){
            tren.add((Vagon)v);
        }if(v instanceof Locomotora){
            maquina.add((Locomotora)v);
        }
    }
    
    public int cantidadPasajeros(){
        return tren.stream().mapToInt(v->v.getPasajeros()).sum();
    }
    
    public int cantidadVagonesPopulares(){
        return (int) tren.stream().filter(v->v.getPasajeros()>50).count();
    }
    
    public boolean esCarguera(){
        return tren.stream().allMatch(v->v.getCargaMaxima()>=1000);
    }
    
    public int dispersionDePesos(){
        return tren.stream().max(Comparator.comparing(Vagon::getPeso)).get().getPeso() 
                - tren.stream().min(Comparator.comparing(Vagon::getPeso)).get().getPeso();
    }
    
    public int cantidadDeBaños(){
        return (int) tren.stream().filter(v->v.isBaño()).count();
    }
    

    public void mantenimieto(){          
        for(int i = 0;i<tren.size();i++){
            if(tren.get(i) instanceof VagonPasajeros){
               VagonPasajeros aux = (VagonPasajeros)tren.get(i);
               aux.setOrdenado(true);
               tren.set(i, aux);
            }
            if(tren.get(i) instanceof VagonCarga){
                VagonCarga aux = (VagonCarga)tren.get(i);
                aux.setMaderasSueltas(aux.getMaderasSueltas()<2?0:aux.getMaderasSueltas()-2);
                tren.set(i, aux);
            }
        }
    }
    
    
    public boolean equilibradaEnPasajeros(){
        return (
                tren.stream().filter(v->v.getPasajeros()>0).max(Comparator.comparing(Vagon::getPasajeros)).get().getPasajeros() -
                tren.stream().filter(v->v.getPasajeros()>0).min(Comparator.comparing(Vagon::getPasajeros)).get().getPasajeros() 
                ) <= 20;
    } 
    
    public boolean esOrganizada(){
       
        boolean flag = false;
        for(Vagon v : tren){
            if(v.getPasajeros()>0){
                if(flag)
                    return false;
            }
            else{
                flag = true;
            }
        }
        return true;
    }
    
    
    public Vagon vagonMasPesado(){
        return tren.stream().max(Comparator.comparing(Vagon::getPeso)).get();
    }
    
    
    ////////////////////////////////
    //  LOCOMOTORAS
    ///////////////////////////////

    
    public int velocidadMaxima(){
        return maquina.stream().min(Comparator.comparing(Locomotora::getVelocidadMaxima)).get().getVelocidadMaxima();
    }
    
    public boolean esEficiente(){
        return maquina.stream().allMatch(l->l.esEficiente());
    }
    
    public boolean puedeMoverse(){
        return maquina.stream().mapToInt(l->l.getPesoArrastre()).sum() 
                >= (maquina.stream().mapToInt(l->l.getPeso()).sum() + tren.stream().mapToInt(v->v.getPeso()).sum());
    }
    
    public int kilosDeEmpuje(){
        return puedeMoverse()?0:(pesoTotal() - maquina.stream().mapToInt(l->l.getPesoArrastre()).sum());
    }
    
    //////////////////////////////
    //  TODO
    /////////////////////////////
    
    public int tamaño(){
        return tren.size() + maquina.size();
    }
    
    public int pesoTotal(){
        return maquina.stream().mapToInt(l->l.getPeso()).sum() + tren.stream().mapToInt(v->v.getPeso()).sum();
    }
}
