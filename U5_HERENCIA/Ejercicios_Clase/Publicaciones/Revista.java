package com.company.Publicaciones;

import java.util.Enumeration;

public class Revista extends Publicacion{

    private Integer numero;

    public Revista(String isbn, String titulo, Integer yearPublicacion, Integer numero) {
        super(isbn, titulo, yearPublicacion);
        this.numero= numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return super.toString() +
                "numero=" + numero +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
