package com.company.STAX.Entregable_3;

import java.util.Objects;

public class Perro2 {

    private String nombre;
    private String raza;
    private Integer edad;
    private Integer id;
    private static Integer contador=0;

    public Perro2(String nombre, String raza, Integer edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.id=contador;
        Perro2.contador++;
    }

    public Perro2() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perro2 perro = (Perro2) o;
        return nombre.equals(perro.nombre) && raza.equals(perro.raza) && edad.equals(perro.edad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, raza, edad);
    }
}
