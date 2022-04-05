package com.company.Maps.Criptomoneda;

import java.util.Objects;

public class Fiat extends Divisa{

    private String pais_referencia;


    public Fiat(String nombre, String simbolo, Integer id, String pais_referencia) {
        super(nombre, simbolo, id);
        this.pais_referencia=pais_referencia;
    }

    public String getPais_referencia() {
        return pais_referencia;
    }

    public void setPais_referencia(String pais_referencia) {
        this.pais_referencia = pais_referencia;
    }

    @Override
    public String toString() {
        return "Fiat{" + super.toString() +
                "pais_referencia='" + pais_referencia + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fiat fiat = (Fiat) o;
        return Objects.equals(pais_referencia, fiat.pais_referencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pais_referencia);
    }
}
