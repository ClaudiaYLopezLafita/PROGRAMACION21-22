package com.company.EX_EmpresaFara;

import java.util.Objects;

public abstract class Vehiculo {
    private String matricula;
    private Double cargaMaxima;
    private Conductor conductor;

    public Vehiculo(String matricula, Double cargaMaxima, Conductor conductor) {
        this.matricula = matricula;
        this.cargaMaxima = cargaMaxima;
        this.conductor = conductor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(Double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public abstract void descargar();

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", cargaMaxima=" + cargaMaxima +
                ", conductor=" + conductor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return matricula.equals(vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}
