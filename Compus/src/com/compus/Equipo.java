/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compus;

import java.io.Serializable;

/**
 *
 * @author supernona
 */
public class Equipo {
    String nombre;
    int compu;
    boolean funcional;
            
     public Equipo() {
       
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCompu(int compu) {
        this.compu = compu;
    }
    
    public void setFunciona(boolean deci){
        this.funcional=deci;
    }
    
    public boolean getFunciona(){
        return funcional;
    }
    
     public String getNombre(){
        return nombre;
    }
    
    
    public int getCompu() {
        return compu;
    }

    
}
