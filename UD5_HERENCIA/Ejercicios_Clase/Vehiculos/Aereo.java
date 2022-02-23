package com.company.Vehiculos;

import java.util.Objects;

public abstract class Aereo extends Vehiculo implements Volar{

    private Integer altitud;
    private String codigo;

    public Aereo(String nombre, Integer capacidad, Integer altitud, String codigo) {
        super(nombre, capacidad);
        this.altitud = altitud;
        this.codigo = codigo;
    }

    public Integer getAltitud() {
        return altitud;
    }

    public void setAltitud(Integer altitud) {
        this.altitud = altitud;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    @Override
    public void volar() {
        System.out.println("Altitud: "+this.getAltitud());
        System.out.println("Clase: "+this.getClass().toString());
    }

    @Override
    public String toString() {
        return "VehiculoAereo{" +
                "altitud=" + altitud +
                ", codigo='" + codigo + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aereo that = (Aereo) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }


}
