package com.company.FicherosBinarios.Complementarios.Ejer09.Maquinaria;

import com.company.FicherosBinarios.Complementarios.Ejer09.Personal.Mecanico;

import java.util.Objects;

public class Locomotora {

    private String matricula;
    private Double potencia;
    private Integer year;
    private Mecanico mecanico;

    public Locomotora(String matricula, Double potencia, Integer year, Mecanico mecanico) {
        this.matricula = matricula;
        this.potencia = potencia;
        this.year = year;
        this.mecanico = mecanico;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getPotencia() {
        return potencia;
    }

    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    @Override
    public String toString() {
        return "Locomotora{" +
                "matricula='" + matricula + '\'' +
                ", potencia=" + potencia +
                ", year=" + year +
                ", mecanico=" + mecanico +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locomotora that = (Locomotora) o;
        return matricula.equals(that.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}
