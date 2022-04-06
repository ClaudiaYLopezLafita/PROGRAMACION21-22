package com.company.Ex_RazaPerros;

import java.io.Serializable;
import java.util.Objects;

public class Perro implements Serializable, Comparable<Perro> {

    private String nombre;
    private Integer edad;
    private Double peso;
    private boolean vacunas;
    private Propietario propietario;
    private String raza;

    public Perro(String nomobre, Integer edad, Double peso, boolean vacunas, Propietario propietario, String raza) {
        this.nombre = nomobre;
        this.edad = edad;
        this.peso = peso;
        this.vacunas = vacunas;
        this.propietario = propietario;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public boolean isVacunas() {
        return vacunas;
    }

    public void setVacunas(boolean vacunas) {
        this.vacunas = vacunas;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "nomobre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", vacunas=" + vacunas +
                ", propietario=" + propietario +
                ", raza='" + raza + '\'' +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perro perro = (Perro) o;
        return vacunas == perro.vacunas && Objects.equals(nombre, perro.nombre) && Objects.equals(edad, perro.edad) && Objects.equals(peso, perro.peso) && Objects.equals(propietario, perro.propietario) && Objects.equals(raza, perro.raza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, peso, vacunas, propietario, raza);
    }

    @Override
    public int compareTo(Perro o) {
        return this.nombre.compareTo(o.nombre);
    }
}
