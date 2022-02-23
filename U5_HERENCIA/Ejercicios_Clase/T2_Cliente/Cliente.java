package com.company.T2_Cliente;

import java.util.Objects;

public class Cliente implements Comparable{

    private String dni;
    private String nombre;
    private int edad;
    private Double saldo;

    public Cliente(String dni, String nombre, int edad, Double saldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.saldo = saldo;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = Double.valueOf(saldo);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", saldo=" + saldo + '\n'+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return dni.equals(cliente.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    /*
    OJO, cuando se diga en el enunciado que se implemente un interfaz Comparable, se refierea a usar
    "implements Comparable" dado que es un interfaz en sí.
     */
    @Override
    public int compareTo(Object o) {
        Cliente c = (Cliente) o;

        //return this.getEdad()-c.getEdad();
        return this.getDni().compareTo(c.getDni());
    }
}
