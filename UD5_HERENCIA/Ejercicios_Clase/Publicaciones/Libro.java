package com.company.Publicaciones;

import java.util.Objects;

public class Libro extends Publicacion implements Prestable, Comparable<Libro>{

    private boolean prestado;

    public Libro(String isbn, String titulo, Integer yearPublicacion, boolean prestado) {
        super(isbn, titulo, yearPublicacion);
        this.prestado = false;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return super.toString() +
                " (" + (this.prestado ? "prestado" : "no prestado") + ")" ;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }

    @Override
    public void presta() {
        if (this.prestado) {
            System.out.println("Lo siento, ese libro ya está prestado.");
        } else {
            this.prestado = true;
        }
    }

    @Override
    public void devuelve() {
        prestado = false;

    }

    @Override
    public int compareTo(Libro o) {
        return this.getIsbn().compareTo(o.getIsbn());
    }
}
