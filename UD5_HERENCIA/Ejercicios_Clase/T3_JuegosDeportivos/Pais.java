package com.company.T3_JuegosDeportivos;

import java.util.Objects;

public class Pais implements Comparable<Pais>{
    private  String nombre;
    private Integer numIntegrantes;

    public Pais(String nombre, Integer numIntegrantes) {
        this.nombre = nombre;
        this.numIntegrantes = numIntegrantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumParticipantes() {
        return numIntegrantes;
    }

    public void setNumParticipantes(int numParticipantes) {
        this.numIntegrantes = numParticipantes;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nombre='" + nombre + '\'' +
                ", numParticipantes=" + numIntegrantes +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(nombre, pais.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public int compareTo(Pais pais) {
        return this.getNombre().compareTo(pais.getNombre());
    }
}
