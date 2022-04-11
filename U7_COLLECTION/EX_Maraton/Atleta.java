package com.company.EX_Maraton;

import java.io.Serializable;
import java.util.Objects;

public class Atleta implements Serializable, Comparable<Atleta> {

    private String nombre;
    private Integer dorsal;
    private String pais;
    private Integer marca;
    private Categoria categoria;
    private boolean finisher;
    private  static int numAtletas=1;

    public Atleta(String nombre, String pais, Categoria categoria) {
        this.nombre = nombre;
        this.dorsal = numAtletas;
        this.pais = pais;
        this.marca = 0;
        this.categoria = categoria;
        this.finisher = false;
        Atleta.numAtletas++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isFinisher() {
        return finisher;
    }

    public void setFinisher(boolean finisher) {
        this.finisher = finisher;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "nombre='" + nombre + '\'' +
                ", dorsal=" + dorsal +
                ", pais='" + pais + '\'' +
                ", marca=" + marca +
                ", categoria=" + categoria +
                ", finisher=" + finisher +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atleta atleta = (Atleta) o;
        return dorsal.equals(atleta.dorsal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dorsal);
    }

    @Override
    public int compareTo(Atleta o) {
        return this.marca.compareTo(o.marca);
    }
}
