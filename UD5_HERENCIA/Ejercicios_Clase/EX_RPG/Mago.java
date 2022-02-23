package com.company.EX_RPG;

public class Mago extends Hombres implements Magia{

    private Double longBarba;


    public Mago(String nombre, Integer energia, Integer capAtaque, Integer capDefensa,
                boolean encantado, Double longBarba) {
        super(nombre, energia, capAtaque, capDefensa, encantado);
        this.longBarba=longBarba;
    }

    public Double getLongBarba() {
        return longBarba;
    }

    public void setLongBarba(Double longBarba) {
        this.longBarba = longBarba;
    }

    @Override
    public String toString() {
        return super.toString() +
                "longBarba=" + longBarba +
                '}';
    }
}
