package com.company.GrupoTarde;

import java.util.Objects;

public abstract class Multimedia implements Comparable<Multimedia> {

    private String titulo;
    private String director;
    private Integer year;
    private Integer id;
    static Integer contadorId =1;
    private boolean finalizado;

    public Multimedia(String titulo, String director, Integer year, boolean finalizado) {
        this.titulo = titulo;
        this.director = director;
        this.year = year;
        this.id = contadorId++;
        this.finalizado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Integer getContadorId() {
        return contadorId;
    }

    public static void setContadorId(Integer contadorId) {
        Multimedia.contadorId = contadorId;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public void dar_por_finalizado(Multimedia m){
        System.out.println("Se ha finalizado "+ m.getTitulo());
    }

    @Override
    public String toString() {
        return "\n[" +
                "titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                ", id=" + id +
                ", finalizado=" + finalizado +
                ',';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multimedia that = (Multimedia) o;
        return titulo.equals(that.titulo) && director.equals(that.director) && year.equals(that.year) && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, director, year, id);
    }

    @Override
    public int compareTo(Multimedia o) {
        return this.id-o.id;
    }
}
