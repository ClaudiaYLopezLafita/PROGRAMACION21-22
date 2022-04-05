package com.company.FicherosBinarios.Complementarios.Ejer09.Maquinaria;

import java.util.Objects;

public class Vagone {

    private Double capMax;
    private Double capActual;
    private Double tipoMercancia;

    public Vagone(Double capMax, Double capActual, Double tipoMercancia) {
        this.capMax = capMax;
        this.capActual = capActual;
        this.tipoMercancia = tipoMercancia;
    }

    public Double getCapMax() {
        return capMax;
    }

    public void setCapMax(Double capMax) {
        this.capMax = capMax;
    }

    public Double getCapActual() {
        return capActual;
    }

    public void setCapActual(Double capActual) {
        this.capActual = capActual;
    }

    public Double getTipoMercancia() {
        return tipoMercancia;
    }

    public void setTipoMercancia(Double tipoMercancia) {
        this.tipoMercancia = tipoMercancia;
    }

    @Override
    public String toString() {
        return "Vagone{" +
                "capMax=" + capMax +
                ", capActual=" + capActual +
                ", tipoMercancia=" + tipoMercancia +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vagone vagone = (Vagone) o;
        return Objects.equals(capMax, vagone.capMax) && Objects.equals(capActual, vagone.capActual) && Objects.equals(tipoMercancia, vagone.tipoMercancia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capMax, capActual, tipoMercancia);
    }
}
