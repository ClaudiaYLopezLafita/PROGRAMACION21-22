package com.company.Maps.Tarea5_MapyFicheros;

import java.io.Serializable;
import java.util.Objects;

public class Aspirante implements Serializable {

    private String nombre;
    private String dni;
    private String teléfono;

    public Aspirante(String nombre, String dni, String teléfono) {
        this.nombre = nombre;
        this.dni = dni;
        this.teléfono = teléfono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    @Override
    public String toString() {
        return "Aspirante{" +
                "nombre:'" + nombre + '\'' +
                ", dni:'" + dni + '\'' +
                ", teléfono:'" + teléfono + '\'' +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aspirante aspirante = (Aspirante) o;
        return dni.equals(aspirante.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
