package com.company.EJER_Baloncesto;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Jugador j1 = new Jugador("Carlos", "Cuevas",170,23);
        Jugador j5 = new Jugador("Carmes", "Cuevas",160,36);
        Jugador j6 = new Jugador("Clara", "Cuevas",100,89);
        Jugador j2 = new Jugador("Gema", "Maria",190,40);
        Jugador j3 = new Jugador("Manuel", "Moreno",206,29);
        Jugador j4 = new Jugador("Claudia", "Lopez",150,30);

        ClubBaloncesto cb = new ClubBaloncesto();
        cb.cargarJugadores();

        cb.addJugador(j1);
        cb.addJugador(j2);
        cb.addJugador(j3);
        cb.addJugador(j4);
        cb.addJugador(j5);
        cb.addJugador(j6);

        System.out.println(cb);
        cb.removeJugador(j1);
        cb.mostrarJugadores("BAJO");
        cb.mostrarJugadorPorAltura();
        System.out.println();
        cb.mostrarJugadorPorAltura2();
        System.out.println();
        cb.mostrarJugadorPorAltura3();

        cb.mostrarJugadorRangoEdad(30, 40);

        cb.guardarJugadores();
    }


}
