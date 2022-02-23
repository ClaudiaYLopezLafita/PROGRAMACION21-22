package com.company.T2_Figura;

import java.util.Objects;

public class Circulo implements Figura, Comparable{

    private Double radio;


    public Circulo(Double radio) {
        this.radio = radio;
    }

    public  Circulo(){
        this(10.0);
    }

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "radio=" + radio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circulo circulo = (Circulo) o;
        return radio.equals(circulo.radio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radio);
    }

    @Override
    public Double getArea() {
        Double area = Math.PI*Math.pow(radio,2.0);

        return area;
    }

    @Override
    public int compareTo(Object o) {

        Circulo c = (Circulo) o;

        return (int) (this.radio-c.radio);
        // cambiar los isgnos en caso de que lo queramos descendente
    }
}
