package com.company.Listas.Instituto;

import java.io.Serializable;
import java.util.Objects;

public class Unidad implements Serializable {

    private String nombre;

    //  ArrayList<Alumno> alumnos;

    public Unidad(String nombre) {
       this.nombre=nombre;
        //    this.alumnos = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unidad)) return false;
        Unidad unidad = (Unidad) o;
        return Objects.equals(nombre, unidad.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Unidad{" +
                "nombre:'" + nombre + '\'' +
                '}';
    }

    //  public void add_alumno(Alumno a) {
    //    if (!alumnos.contains(a)) {
    //      alumnos.add(a);
    //    }
    //  }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
