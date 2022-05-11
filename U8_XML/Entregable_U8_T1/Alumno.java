package com.company.ENTREGABLE.EJer01;

import java.util.Objects;

public class Alumno implements Comparable<Alumno>{

    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;

    public Alumno(String dni, String nombre, String apellido, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public Alumno() {

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return dni.equals(alumno.dni) && nombre.equals(alumno.nombre) && apellido.equals(alumno.apellido) && direccion.equals(alumno.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, apellido, direccion);
    }


    @Override
    public int compareTo(Alumno o) {
        return dni.compareTo(o.dni);
    }
}
