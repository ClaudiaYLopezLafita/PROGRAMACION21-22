package com.company.Maps.Criptomoneda;

import java.util.Objects;

public class Divisa implements Comparable<Divisa>{

    private String nombre;
    private String simbolo;
    private Integer id;
    private static Integer contador = 0;

    public Divisa(String nombre, String simbolo, Integer id) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.id = contador++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Divisa{" +
                "nombre='" + nombre + '\'' +
                ", simbolo='" + simbolo + '\'' +
                ", id=" + id +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Divisa divisa = (Divisa) o;
        return Objects.equals(nombre, divisa.nombre) && Objects.equals(simbolo, divisa.simbolo) && Objects.equals(id, divisa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, simbolo, id);
    }

    @Override
    public int compareTo(Divisa o) {
        return this.simbolo.compareTo(o.getSimbolo());
    }
}
