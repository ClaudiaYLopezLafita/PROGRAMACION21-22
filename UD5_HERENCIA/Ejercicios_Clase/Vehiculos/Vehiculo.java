package com.company.Vehiculos;

public abstract class Vehiculo {

    private String nombre;
    private Integer capacidad;
    private Integer numPersonas;

    public Vehiculo(String nombre, Integer capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.numPersonas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Vehiculos{" +
                "nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }

    public boolean transportar(int numPersonas) {
        if (numPersonas>capacidad) {
            return false;
        }

        this.numPersonas = numPersonas;
        return true;
    }
}
