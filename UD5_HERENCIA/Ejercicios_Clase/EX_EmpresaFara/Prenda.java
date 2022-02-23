package com.company.EX_EmpresaFara;

import java.util.Objects;

public class Prenda implements Devolver, Doblar{
    private Double precio;
    private String  nombre;
    private String códigoBarra;
    private Double peso;
    private static int contadorPrenda=0;

    public Prenda(Double precio, String nombre, String códigoBarra, Double peso) {
        this.precio = precio;
        this.nombre = nombre;
        this.códigoBarra = códigoBarra;
        this.peso = peso;
        Prenda.contadorPrenda++;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCódigoBarra() {
        return códigoBarra;
    }

    public void setCódigoBarra(String códigoBarra) {
        this.códigoBarra = códigoBarra;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public static int getContadorPrenda() {
        return contadorPrenda;
    }

    public static void setContadorPrenda(int contadorPrenda) {
        Prenda.contadorPrenda = contadorPrenda;
    }

    public void devolver(){
        System.out.println("Devolviendo la prensa con nombre "+ getNombre()+ " y precio " +getPrecio()+"€");
    }

    public void doblar(){
        System.out.println("La prenda "+getNombre()+" se puede dobla");
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "precio=" + precio +
                ", nombre='" + nombre + '\'' +
                ", códigoBarra='" + códigoBarra + '\'' +
                ", peso=" + peso +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenda prenda = (Prenda) o;
        return precio.equals(prenda.precio) && nombre.equals(prenda.nombre) && códigoBarra.equals(prenda.códigoBarra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(precio, nombre, códigoBarra);
    }
}
