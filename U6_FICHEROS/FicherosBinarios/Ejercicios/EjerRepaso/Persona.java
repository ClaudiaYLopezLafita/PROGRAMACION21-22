package com.company.FicherosBinarios.Ejercicios.EjerRepaso;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

public class Persona implements Serializable {
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public Persona(String nombre, String apellido, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}'+'\n';
    }
}
