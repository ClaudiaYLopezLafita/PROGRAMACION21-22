package com.company.T3_JuegosDeportivos;

import java.util.Objects;

public abstract class Participante implements Comparable<Participante>{
    private String nombre;
    private Integer edad;

    public Participante(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public abstract void hacerJuramento();

    @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return nombre.equals(that.nombre) && edad.equals(that.edad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }

    @Override
    public int compareTo(Participante participante) {
        return this.getEdad() - participante.getEdad();
    }
}
