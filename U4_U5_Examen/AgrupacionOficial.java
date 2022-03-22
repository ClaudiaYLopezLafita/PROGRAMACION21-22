package com.company;

import java.util.Comparator;
import java.util.Objects;

public abstract class AgrupacionOficial extends Agrupacion{
    // Comparación de las Agrupaciones oficiales por punto Y AUTOR en Main

    private int numPuntos;

    public AgrupacionOficial(String nombre, String autor, String autorMusica,
                             String autorLetra, String tipoDisfraz, int numPuntos) {
        super(nombre, autor, autorMusica, autorLetra, tipoDisfraz);
        this.numPuntos= numPuntos;
    }

    public int getNumPuntos() {
        return numPuntos;
    }

    public void setNumPuntos(int numPuntos) {
        this.numPuntos = numPuntos;
    }

    public abstract void caminito_del_falla();



    @Override
    public String toString() {
        return super.toString()+"AgrupacionOficial:" +
                "numPuntos=" + numPuntos +
                "]]"+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AgrupacionOficial that = (AgrupacionOficial) o;
        return numPuntos == that.numPuntos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numPuntos);
    }

    @Override
    public abstract void cantar_la_presentacion();


    @Override
    public abstract void hacer_tipo();

}
