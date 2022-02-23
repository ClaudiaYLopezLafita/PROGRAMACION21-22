package com.company.T1_Caja;

public class Etiqueta {

    private String nombre;
    private String direccion;
    private String codBarra;

    public Etiqueta(String nombre, String direccion, String codBarra) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.codBarra = codBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    @Override
    public String toString() {
        return "Etiqueta{" +
                "nombre='" + nombre + '\n' +
                ", direccion='" + direccion + '\n' +
                ", codBarra='" + codBarra + '\n' +
                '}';
    }
}
