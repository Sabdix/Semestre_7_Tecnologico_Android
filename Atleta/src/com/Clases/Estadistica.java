/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Clases;

/**
 *
 * @author sabdi
 */
public class Estadistica {
    public static int [][] rendimiento = new int[4][5];
    
    public static int sumaColumnas(int columna) {
        int suma = 0;
        
        for (int i=0; i < 4; i++) {
            suma += rendimiento[i][columna];
        }
        
        return suma;
    }
}
