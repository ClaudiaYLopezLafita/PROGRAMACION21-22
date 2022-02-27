package com.company.GrupoTarde;

import java.util.Objects;

public class Libro  extends Multimedia {

    private String editorial;
    private String isbn;
    private Integer numPaginas;

    public Libro(String titulo, String director, Integer year, boolean finalizado,
                 String editorial, String isbn, Integer numPaginas) {
        super(titulo, director, year, finalizado);
        this.editorial = editorial;
        this.isbn = isbn;
        this.numPaginas = numPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public String toString() {
        return super.toString() +
                "editorial='" + editorial + '\'' +
                ", isbn='" + isbn + '\'' +
                ", numPaginas=" + numPaginas +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Libro libro = (Libro) o;
        return editorial.equals(libro.editorial) && isbn.equals(libro.isbn) && numPaginas.equals(libro.numPaginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), editorial, isbn, numPaginas);
    }
}
