package com.company.Maps.Tarea4;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable {
    private String nombre;
    private String dni;
    private Integer edad;
    private Double estatura;

    public Persona(String nombre, String dni, Integer edad, Double estatura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.estatura = estatura;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    @Override
    public String toString() {
        return "Empleado [" +
                "nombre:'" + nombre + '\'' +
                ", dni:'" + dni + '\'' +
                ", edad:" + edad +
                ", estatura:" + estatura ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return dni.equals(persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
