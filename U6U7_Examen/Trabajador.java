package com.company;

import java.io.Serializable;
import java.util.Objects;

public class Trabajador implements Serializable, Comparable<Trabajador> {

    private String nombre;
    private String apellido;
    private String dni;
    private Integer edad;
    private String formacionAcademica;

    public Trabajador(String nombre, String apellido, String dni, Integer edad, String formacionAcademica) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.formacionAcademica = formacionAcademica;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getFormacionAcademica() {
        return formacionAcademica;
    }

    public void setFormacionAcademica(String formacionAcademica) {
        this.formacionAcademica = formacionAcademica;
    }

    @Override
    public String toString() {
        return "{" +
                "nombre:'" + nombre + '\'' +
                ", apellido:'" + apellido + '\'' +
                ", dni:'" + dni + '\'' +
                ", edad:" + edad +
                ", formacionAcademica:'" + formacionAcademica + '\'' +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trabajador that = (Trabajador) o;
        return dni.equals(that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public int compareTo(Trabajador t) {
         if(this.apellido.equals(t.apellido)){
            return this.nombre.compareTo(t.nombre);
        }
        return this.apellido.compareTo(t.apellido);
    }
}
