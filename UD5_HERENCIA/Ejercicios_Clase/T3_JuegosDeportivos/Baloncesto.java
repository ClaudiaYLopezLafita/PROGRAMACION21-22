package com.company.T3_JuegosDeportivos;

import java.util.Arrays;
import java.util.Comparator;

public class Baloncesto extends Deporte implements Encestar{

    private Integer numEquipos;

    public Baloncesto(String nombre, String nomPabellon, Integer numEquipos) {
        super(nombre, nomPabellon);
        this.numEquipos=numEquipos;
    }

    public int getNumEquipos() {
        return numEquipos;
    }

    public void setNumEquipos(int numEquipos) {
        this.numEquipos = numEquipos;
    }

    /*
obj instanceOf Object
Al lado izquierdo tenemos la instancia y el lado derecho el nombre de la clase y como resultado
el operador instanceOf devuelve un resultado booleano. Con este resultado (true o false, verdadero o falso)
podemos determinar si el objeto al que apunta una referencia dada es una instancia de una clase o interfaz
concretas.
     */
    @Override
    public boolean addParticipante(Participante participante) {
//Si el participante no es un jugador de baloncesto no lo añadimos.
        if (participante instanceof JugadorBaloncesto) {
            return super.addParticipante(participante);
        }
        return false;
    }

    public void mostrarJugadoresBaloncestoPorAltura() {
        System.out.println("Jugadores de baloncesto ordenados por su altura:");
        Arrays.sort(getParticipantes(), new Comparator<Participante>() {
            @Override
            public int compare(Participante p1, Participante p2) {
                JugadorBaloncesto jug1 = (JugadorBaloncesto) p1;
                JugadorBaloncesto jug2 = (JugadorBaloncesto) p2;
                return Double.compare(jug1.getAltura(), jug2.getAltura());
            }
        });

        for (Participante participante : getParticipantes()) {
            System.out.println(participante);
        }
    }

    @Override
    public String toString() {
        return "Baloncesto{" +
                "numEquipos=" + numEquipos +
                "} " + super.toString();
    }

}
