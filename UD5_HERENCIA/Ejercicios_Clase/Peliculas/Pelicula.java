package com.company.Peliculas;
/*
Ejemplo para practicar el comparator y comparable.
 */
import java.util.Objects;

public class Pelicula implements Comparable<Pelicula>{

    private String titulo;
    private Integer anio;
    private Integer duracion;

    public Pelicula(String titulo, Integer anio, Integer duracion) {
        this.titulo = titulo;
        this.anio = anio;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", duracion=" + duracion +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return titulo.equals(pelicula.titulo) && anio.equals(pelicula.anio) && duracion.equals(pelicula.duracion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, anio, duracion);
    }

    // por defecto es la duracion
    // si se quiere comparar por años y estos coinciden se ordena descendentemente por la duracion (defecto).
    @Override
    public int compareTo(Pelicula o) {
        return this.duracion-o.getDuracion();
    }
}
