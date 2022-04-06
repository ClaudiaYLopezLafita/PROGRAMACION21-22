package com.company.Ex_RazaPerros;

import java.io.Serializable;
import java.util.Objects;

public class Propietario implements Serializable {

    private String nombre;
    private String apellidos;
    private String nss;
    private String pais;

    public Propietario(String nombre, String apellidos, String nss, String pais) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nss = nss;
        this.pais = pais;
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

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nss='" + nss + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Propietario that = (Propietario) o;
        return nss.equals(that.nss);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nss);
    }
}
