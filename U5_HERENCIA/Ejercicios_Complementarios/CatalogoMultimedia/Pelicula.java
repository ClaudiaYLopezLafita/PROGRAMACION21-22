package com.company.GrupoTarde;

import java.util.Objects;

public class Pelicula extends Multimedia implements Reproducir {

    private Integer duracion;
    private String productora;
    private String pais;

    public Pelicula(String titulo, String director, Integer year, boolean finalizado,
                    Integer duracion, String productora, String pais) {
        super(titulo, director, year, finalizado);
        this.duracion = duracion;
        this.productora=productora;
        this.pais= pais;
    }


    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return super.toString() +
                "duracion=" + duracion +
                ", productora='" + productora + '\'' +
                ", pais='" + pais + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pelicula pelicula = (Pelicula) o;
        return duracion.equals(pelicula.duracion) && productora.equals(pelicula.productora) && pais.equals(pelicula.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duracion, productora, pais);
    }

    @Override
    public void play() {
        System.out.println("Reproduciendo pelicula " + getTitulo());
    }

    @Override
    public void pause() {
        System.out.println("Pausando pelicula " + getTitulo());
    }

    @Override
    public void stop() {
        System.out.println("Parando pelicula " + getTitulo());
    }
}
