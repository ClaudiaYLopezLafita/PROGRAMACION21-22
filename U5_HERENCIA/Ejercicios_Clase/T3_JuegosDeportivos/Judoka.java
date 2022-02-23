package com.company.T3_JuegosDeportivos;

public class Judoka extends Participante implements Luchar{

    private Integer pesoCategoria;

    public Judoka(String nombre, Integer edad, Integer pesoCategoria) {
        super(nombre, edad);
        this.pesoCategoria=pesoCategoria;
    }

    public void setPesoCategoria(Integer pesoCategoria) {
        this.pesoCategoria = pesoCategoria;
    }

    public Integer getPesoCategoria() {
        return pesoCategoria;
    }

    @Override
    public String toString() {
        return super.toString() +
                "pesoCategoria=" + pesoCategoria +
                '}';
    }

    @Override
    public void hacerJuramento() {
        System.out.println( "Yo "+getNombre()+", como judoka, juro los valores deportivos mundiales");
    }

    @Override
    public void luchar() {
        System.out.println("Voy a Luchar");
    }
}
