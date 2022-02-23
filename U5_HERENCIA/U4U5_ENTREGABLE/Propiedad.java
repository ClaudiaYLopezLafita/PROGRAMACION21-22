package com.company;

import java.util.Comparator;
import java.util.Objects;

public abstract class Propiedad implements Comparable<Propiedad> {

    private Integer year;
    private String direccion;
    private Double superficie;

    public Propiedad(Integer year, String direccion, Double superficie) {
        this.year = year;
        this.direccion = direccion;
        this.superficie = superficie;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    public abstract void mostrarPropiedad();

    @Override
    public String toString() {
        return "Propiedad{" +
                "year=" + year +
                ", direccion='" + direccion + '\'' +
                ", superficie=" + superficie +
                ','+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Propiedad propiedad = (Propiedad) o;
        return year.equals(propiedad.year) && direccion.equals(propiedad.direccion) && superficie.equals(propiedad.superficie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, direccion, superficie);
    }

    @Override
    public int compareTo(Propiedad p) {
        return (int) (this.getSuperficie()- p.getSuperficie());
    }
}
