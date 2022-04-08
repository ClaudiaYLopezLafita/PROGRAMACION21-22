package com.company.EX_Coronavirus;

import java.io.Serializable;
import java.util.Objects;

public class Paciente implements Serializable, Comparable<Paciente> {

    private String nombre;
    private Integer edad;
    private Double peso;
    private boolean vacunas;
    private Medico medico;
    private String cepa;

    public Paciente(String nombre, Integer edad, Double peso, boolean vacunas, Medico medico, String cepa) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.vacunas = vacunas;
        this.medico = medico;
        this.cepa = cepa;
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getCepa() {
        return cepa;
    }

    public void setCepa(String cepa) {
        this.cepa = cepa;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", vacunas=" + vacunas +
                ", medico=" + medico +
                ", cepa='" + cepa + '\'' +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return vacunas == paciente.vacunas && Objects.equals(nombre, paciente.nombre) && Objects.equals(edad, paciente.edad) && Objects.equals(peso, paciente.peso) && Objects.equals(medico, paciente.medico) && Objects.equals(cepa, paciente.cepa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, peso, vacunas, medico, cepa);
    }

    @Override
    public int compareTo(Paciente o) {
        return this.edad.compareTo(o.edad);
    }
}
