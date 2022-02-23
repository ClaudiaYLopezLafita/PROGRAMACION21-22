package com.company.EX_EmpresaFara;

import java.util.Objects;

public class PrendaColgada extends Prenda implements Colgar{
    private Double altura;

    public PrendaColgada(Double precio, String nombre, String códigoBarra, Double peso, Double altura) {
        super(precio, nombre, códigoBarra, peso);
        this.altura = altura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public void doblar(){
        System.out.println("La prenda "+getNombre()+" NO se puede dobla");
    }

    public void colgar(){
        System.out.println("La prenda "+getNombre()+ " está colgada");
    }
    @Override
    public String toString() {
        return super.toString() +
                "altura=" + altura +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PrendaColgada that = (PrendaColgada) o;
        return altura.equals(that.altura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), altura);
    }
}
