package com.company.EX_Coronavirus;

import java.io.Serializable;
import java.util.Objects;

public class Medico implements Serializable {

    private String nombre;
    private String apellidos;
    private Integer numColegiado;
    private String hospital;

    public Medico(String nombre, String apellidos, Integer numColegiado, String hospital) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numColegiado = numColegiado;
        this.hospital = hospital;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(Integer numColegiado) {
        this.numColegiado = numColegiado;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", numColegiado=" + numColegiado +
                ", hospital='" + hospital + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(nombre, medico.nombre) && Objects.equals(apellidos, medico.apellidos) && Objects.equals(numColegiado, medico.numColegiado) && Objects.equals(hospital, medico.hospital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, numColegiado, hospital);
    }
}
