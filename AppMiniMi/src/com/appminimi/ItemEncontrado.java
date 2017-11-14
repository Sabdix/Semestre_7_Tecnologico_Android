/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appminimi;

/**
 *
 * @author Admin
 */
public class ItemEncontrado 
{
    private String nombre, ruta;
    private double tamanio;
    private boolean carpeta;

    public boolean isCarpeta() {
        return carpeta;
    }

    public void setCarpeta(boolean carpeta) {
        this.carpeta = carpeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

}
