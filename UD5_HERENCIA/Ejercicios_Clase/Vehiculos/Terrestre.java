package com.company.Vehiculos;

import java.util.Objects;

public abstract class Terrestre extends Vehiculo implements Comparable<Terrestre>{

    private String matricula;
    private Color color;
    private Integer anioFabricacion;

    public Terrestre(String nombre, Integer capacidad, String matricula, Color color, Integer anioFabricacion) {
        super(nombre, capacidad);
        this.matricula = matricula;
        this.color = color;
        this.anioFabricacion = anioFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(Integer anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                super.toString()+
                "matricula='" + matricula + '\'' +
                ", color=" + color +
                ", anioFabricacion='" + anioFabricacion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Terrestre terrestre = (Terrestre) o;
        return matricula.equals(terrestre.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public int compareTo(Terrestre terrestre) {
        return this.getMatricula().compareTo(terrestre.getMatricula());
    }
}
