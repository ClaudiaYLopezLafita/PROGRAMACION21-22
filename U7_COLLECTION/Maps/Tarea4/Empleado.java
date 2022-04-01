package com.company.Maps.Tarea4;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable {

    private Double sueldo;

    public Empleado(String nombre, String dni, Integer edad, Double estatura, Double sueldo) {
        super(nombre, dni, edad, estatura);
        this.sueldo = sueldo;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", sueldo:" + sueldo +
                ']'+'\n';
    }
}
