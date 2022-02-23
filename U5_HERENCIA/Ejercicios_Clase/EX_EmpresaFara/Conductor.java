package com.company.EX_EmpresaFara;

public class Conductor {
    private String nombre;
    private String apellido;
    private String nss;

    public Conductor(String nombre, String apellido, String nss) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nss = nss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNss() {
        return nss;
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellido + '\'' +
                ", NSS='" + nss + '\'' +
                '}';
    }
}
