package com.company.STAX.Ejemplos.Ejem03;

import java.util.Objects;

public class Modulo {

    private String código;
    private String nombre;
    private Integer horas;

    public Modulo(String código, String nombre, Integer horas) {
        this.código = código;
        this.nombre = nombre;
        this.horas = horas;
    }

    public String getCódigo() {
        return código;
    }

    public void setCódigo(String código) {
        this.código = código;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "código='" + código + '\'' +
                ", nombre='" + nombre + '\'' +
                ", horas=" + horas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modulo modulo = (Modulo) o;
        return Objects.equals(código, modulo.código) && Objects.equals(nombre, modulo.nombre) && Objects.equals(horas, modulo.horas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(código, nombre, horas);
    }
}
