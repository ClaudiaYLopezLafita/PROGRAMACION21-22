package com.company.Publicaciones;

import java.util.Objects;

public class Publicacion {

    private String isbn;
    private String titulo;
    private Integer yearPublicacion;

    public Publicacion(String isbn, String titulo, Integer yearPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.yearPublicacion = yearPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getYearPublicacion() {
        return yearPublicacion;
    }

    public void setYearPublicacion(Integer yearPublicacion) {
        this.yearPublicacion = yearPublicacion;
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", yearPublicacion=" + yearPublicacion +
                '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicacion that = (Publicacion) o;
        return isbn.equals(that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
