package com.company.FicherosBinarios.Complementarios.Ejer08;

import java.io.Serializable;

public class Cliente implements Serializable {

    private int id;
    private String nombre;
    private String telefono;

    public Cliente(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id:" + id +
                ", nombre:'" + nombre + '\'' +
                ", telefono:'" + telefono + '\'' +
                '}'+'\n';
    }
}
