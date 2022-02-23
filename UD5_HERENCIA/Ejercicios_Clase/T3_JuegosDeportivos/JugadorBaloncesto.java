package com.company.T3_JuegosDeportivos;

import java.util.Objects;

public class JugadorBaloncesto extends Participante implements Encestar{

    private Double altura;

    public JugadorBaloncesto(String nombre, Integer edad, Double altura) {
        super(nombre, edad);
        this.altura=altura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
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
        JugadorBaloncesto that = (JugadorBaloncesto) o;
        return altura.equals(that.altura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), altura);
    }

    @Override
    public void hacerJuramento() {
        System.out.println( "Yo "+getNombre()+", como jugador de baloncesto, juro los valores deportivos mundiales");
    }


}
