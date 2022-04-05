package com.company.Listas.Instituto;

import java.io.Serializable;

public class Alumno implements Serializable, Comparable<Alumno> {

    private String nombre;
    private String apellidos;
    private String dni;

    private Integer id;
    private Unidad unidad;
    private static Integer contador = 0;

    public Alumno(String nombre, String apellidos, String dni, Unidad unidad) {
        this.nombre = nombre;
        this.apellidos=apellidos;
        this.dni=dni;
        this.unidad=unidad;
        this.id=contador++;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                ", id=" + id +
                ", unidad=" + unidad +
                '}'+'\n';
    }

    @Override
    public int compareTo(Alumno alum) {
        return this.dni.compareTo(alum.getDni());
    }
}
