package com.company;

import java.util.Objects;

public class Opositor {

    private String nombre;
    private String apellido;
    private Integer anioNac;
    private Adaptacion adaptacion;
    private String descripAdaptacion;
    private static Integer cantOpositores =0;
    private static Integer cantOpositoresAdaptacion =0;

    public Opositor(String nombre, String apellido, Integer anioNac, Adaptacion adaptacion,
                    String descripAdaptacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioNac = anioNac;
        this.adaptacion = adaptacion;
        if (adaptacion.equals(Adaptacion.SI)){
            this.descripAdaptacion = descripAdaptacion;
            Opositor.cantOpositoresAdaptacion++;
        } else {
            this.descripAdaptacion=null;
        }
        Opositor.cantOpositores++;
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

    public Integer getAnioNac() {
        return anioNac;
    }

    public void setAnioNac(Integer anioNac) {
        this.anioNac = anioNac;
    }

    public Adaptacion getAdaptacion() {
        return adaptacion;
    }

    public void setAdaptacion(Adaptacion adaptacion) {
        this.adaptacion = adaptacion;
    }

    public String getDescripAdaptacion() {
        return descripAdaptacion;
    }

    public void setDescripAdaptacion(String descripAdaptacion) {
        this.descripAdaptacion = descripAdaptacion;
    }

    public Integer getCantOpositores() {
        return cantOpositores;
    }

    public void setCantOpositores(Integer cantOpositores) {
        this.cantOpositores = cantOpositores;
    }

    public Integer getCantidadOpositores(){
        return cantOpositores;
    }

    public static Integer getCantOpositoresAdaptacion() {
        return cantOpositoresAdaptacion;
    }

    public static void setCantOpositoresAdaptacion(Integer cantOpositoresAdaptacion) {
        Opositor.cantOpositoresAdaptacion = cantOpositoresAdaptacion;
    }

    public void mostrar_informacion(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return  ", \n"+ "Opositor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", anioNac=" + anioNac +
                ", adaptacion=" + adaptacion +
                ", descripAdaptacion='" + descripAdaptacion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opositor opositor = (Opositor) o;
        return nombre.equals(opositor.nombre) && apellido.equals(opositor.apellido) && anioNac.equals(opositor.anioNac) && adaptacion == opositor.adaptacion && descripAdaptacion.equals(opositor.descripAdaptacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, anioNac, adaptacion, descripAdaptacion);
    }
}
