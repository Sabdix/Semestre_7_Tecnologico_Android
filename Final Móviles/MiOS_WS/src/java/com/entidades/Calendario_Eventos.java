package com.entidades;

/**
 *
 * @author Alexander
 */
public class Calendario_Eventos 
{
    private int id;
    private int dia;
    private int mes;
    private String nombre_evento;
    private String desc_evento;
    private String ubicacion;
    private String hora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    public String getDesc_evento() {
        return desc_evento;
    }

    public void setDesc_evento(String desc_evento) {
        this.desc_evento = desc_evento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
