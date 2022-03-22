package com.company;

import java.util.Objects;

public class Integrante {

    private int numeroParticipante;
    private String nombre;
    private int edad;
    private String localidad;

    public Integrante(int numeroParticipante, String nombre, int edad, String localidad) {
        this.numeroParticipante = numeroParticipante;
        this.nombre = nombre;
        this.edad = edad;
        this.localidad = localidad;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setNumeroParticipante(int numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Integrante{" +
                "numeroParticipante:'" + numeroParticipante + '\'' +
                ", nombre:'" + nombre + '\'' +
                ", edad:" + edad +
                ", localidad:'" + localidad + '\'' +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Integrante that = (Integrante) o;
        return Objects.equals(numeroParticipante, that.numeroParticipante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroParticipante);
    }
}
