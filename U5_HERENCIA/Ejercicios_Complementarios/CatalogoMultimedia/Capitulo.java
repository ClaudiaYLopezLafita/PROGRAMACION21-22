package com.company.GrupoTarde;

import java.util.Objects;

public class Capitulo {

    private String titulo;

    public Capitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Capitulo: "  + titulo + '\'' +
                '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capitulo capitulo = (Capitulo) o;
        return titulo.equals(capitulo.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
