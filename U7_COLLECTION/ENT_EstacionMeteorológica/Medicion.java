package com.company.ENT_EstacionMeteorológica;

import java.io.Serializable;
import java.util.Objects;

public class Medicion implements Comparable<Medicion>, Serializable {

    private Integer temperatura;
    private Integer humedad;
    private Integer presion;

    public Medicion(Integer temperatura, Integer humedad, Integer presion) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.presion = presion;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getHumedad() {
        return humedad;
    }

    public void setHumedad(Integer humedad) {
        this.humedad = humedad;
    }

    public Integer getPresion() {
        return presion;
    }

    public void setPresion(Integer presion) {
        this.presion = presion;
    }

    @Override
    public String toString() {
        return "Medicion{" +
                "temperatura:" + temperatura +
                ", humedad:" + humedad +
                ", presion:" + presion +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicion medicion = (Medicion) o;
        return temperatura.equals(medicion.temperatura) && humedad.equals(medicion.humedad) && presion.equals(medicion.presion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperatura, humedad, presion);
    }

    @Override
    public int compareTo(Medicion o) {
        return this.temperatura.compareTo(o.temperatura);
    }
}
