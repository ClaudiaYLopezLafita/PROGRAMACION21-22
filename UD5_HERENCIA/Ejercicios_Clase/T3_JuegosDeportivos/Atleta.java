package com.company.T3_JuegosDeportivos;

import java.util.Objects;

public class Atleta extends Participante implements Correr{
    private String nombrePrueba;

    public Atleta(String nombre, Integer edad, String nombrePrueba) {
        super(nombre, edad);
        this.nombrePrueba=nombrePrueba;
    }

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
    }

    @Override
    public String toString() {
        return super.toString() +
                "nombrePrueba='" + nombrePrueba + '\'' +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Atleta atleta = (Atleta) o;
        return nombrePrueba.equals(atleta.nombrePrueba);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nombrePrueba);
    }

    @Override
    public void hacerJuramento() {
        System.out.println( "Yo "+getNombre()+", como atleta, juro los valores deportivos mundiales");
    }

}
