package com.company.EJER_Baloncesto;

import java.io.Serializable;
import java.util.Objects;

public class Jugador implements Serializable, Comparable<Jugador> {

    private String nombre;
    private String apellido;
    private Integer altura;
    private Integer edad;

    public Jugador(String nombre, String apellido, Integer altura, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", altura=" + altura +
                ", edad=" + edad +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return nombre.equals(jugador.nombre) && apellido.equals(jugador.apellido) && altura.equals(jugador.altura) && edad.equals(jugador.edad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, altura, edad);
    }

    @Override
    public int compareTo(Jugador o) {
        return this.getEdad()-o.getEdad();
    }
}
