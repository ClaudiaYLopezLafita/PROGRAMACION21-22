package com.company;

import java.util.Comparator;
import java.util.Objects;

public abstract class Agrupacion implements Comparable<Agrupacion>, Comparator<Agrupacion>{

    private String nombre;
    private String autor;
    private String autorMusica;
    private String autorLetra;
    private String tipoDisfraz;
    private static int numAgrupaciones;

    public Agrupacion(String nombre, String autor, String autorMusica, String autorLetra, String tipoDisfraz) {
        this.nombre = nombre;
        this.autor = autor;
        this.autorMusica = autorMusica;
        this.autorLetra = autorLetra;
        this.tipoDisfraz = tipoDisfraz;
        Agrupacion.numAgrupaciones++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutorMusica() {
        return autorMusica;
    }

    public void setAutorMusica(String autorMusica) {
        this.autorMusica = autorMusica;
    }

    public String getAutorLetra() {
        return autorLetra;
    }

    public void setAutorLetra(String autorLetra) {
        this.autorLetra = autorLetra;
    }

    public String getTipoDisfraz() {
        return tipoDisfraz;
    }

    public void setTipoDisfraz(String tipoDisfraz) {
        this.tipoDisfraz = tipoDisfraz;
    }

    public static int getNumAgrupaciones() {
        return numAgrupaciones;
    }

    public static void setNumAgrupaciones(int numAgrupaciones) {
        Agrupacion.numAgrupaciones = numAgrupaciones;
    }

    public abstract void cantar_la_presentacion();
    public abstract void hacer_tipo() ;

    @Override
    public String toString() {
        return "Agrupacion{" +
                "nombre:'" + nombre + '\'' +
                ", autor:'" + autor + '\'' +
                ", autorMusica:'" + autorMusica + '\'' +
                ", autorLetra:'" + autorLetra + '\'' +
                ", tipoDisfraz:'" + tipoDisfraz + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agrupacion that = (Agrupacion) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(autor, that.autor) && Objects.equals(autorMusica, that.autorMusica) && Objects.equals(autorLetra, that.autorLetra) && Objects.equals(tipoDisfraz, that.tipoDisfraz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, autor, autorMusica, autorLetra, tipoDisfraz);
    }
    // COMPARACION POR DEFECTO NOMBRE DE LAS AGRUACIONES
    @Override
    public int compareTo(Agrupacion o) {
        return this.getNombre().compareTo(o.getNombre());
    }

    //COMPARACION DE LAS AGRUPACIONES POR AUTO
    @Override
    public int compare(Agrupacion o1, Agrupacion o2) {
        return o1.getAutor().compareTo(o2.getAutor());
    }

}
