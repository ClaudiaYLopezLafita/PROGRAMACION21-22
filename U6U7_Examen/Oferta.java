package com.company;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Oferta implements Serializable, Comparable<Oferta>{

    private Integer codigo;
    private String descripcion;
    Set<Trabajador> trabajadors;
    private boolean cubierto;

    public Oferta(Integer codigo, String descripcion, boolean cubierto) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.trabajadors = new TreeSet<>();
        this.cubierto = cubierto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Trabajador> getTrabajadors() {
        return trabajadors;
    }

    public void setTrabajadors(Set<Trabajador> trabajadors) {
        this.trabajadors = trabajadors;
    }

    public boolean isCubierto() {
        return cubierto;
    }

    public void setCubierto(boolean cubierto) {
        this.cubierto = cubierto;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "codigo:" + codigo +
                ", descripcion:'" + descripcion + '\'' +
                ", Trabajadores=" + trabajadors +
                ", cubierto_" + cubierto +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oferta oferta = (Oferta) o;
        return codigo.equals(oferta.codigo) && descripcion.equals(oferta.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descripcion);
    }

    @Override
    public int compareTo(Oferta o) {
        return this.codigo.compareTo(o.codigo);
    }
}
