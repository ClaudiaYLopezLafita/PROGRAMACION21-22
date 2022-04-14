package com.company.ENT_EstacionMeteorológica;

import java.io.Serializable;
import java.util.Objects;

public class Coordenadas implements Serializable {

    private Integer latitud;
    private Integer longitud;

    public Coordenadas(Integer latitud, Integer longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Integer getLatitud() {
        return latitud;
    }

    public void setLatitud(Integer latitud) {
        this.latitud = latitud;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Coordenadas{" +
                "latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenadas that = (Coordenadas) o;
        return latitud.equals(that.latitud) && longitud.equals(that.longitud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitud, longitud);
    }
}
