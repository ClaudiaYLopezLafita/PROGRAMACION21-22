package com.company.FicherosBinarios.Complementarios.Ejer09.Maquinaria;

import java.util.Objects;

public class Tren {

    private Locomotora locomotora;
    private Vagone vagone;
    private static final int maxVagones=5;

    public Tren(Locomotora locomotora, Vagone vagone) {
        this.locomotora = locomotora;
        this.vagone = vagone;
    }

    public Locomotora getLocomotora() {
        return locomotora;
    }

    public void setLocomotora(Locomotora locomotora) {
        this.locomotora = locomotora;
    }

    public Vagone getVagone() {
        return vagone;
    }

    public void setVagone(Vagone vagone) {
        this.vagone = vagone;
    }

    @Override
    public String toString() {
        return "Tren{" +
                "locomotora=" + locomotora +
                ", vagone=" + vagone +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tren tren = (Tren) o;
        return Objects.equals(locomotora, tren.locomotora) && Objects.equals(vagone, tren.vagone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locomotora, vagone);
    }
}
