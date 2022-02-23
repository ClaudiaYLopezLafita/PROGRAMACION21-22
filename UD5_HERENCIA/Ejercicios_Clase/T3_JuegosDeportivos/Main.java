package com.company.T3_JuegosDeportivos;

import com.company.Complementarios.CorteIslandes.TarjetaRegalo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Edicion ed1 = new Edicion(2016, "Rios");

        JugadorBaloncesto jb1 = new JugadorBaloncesto("Paul", 25,1.89);
        JugadorBaloncesto jb2 = new JugadorBaloncesto("Marc", 20,1.90);
        JugadorBaloncesto jb3 = new JugadorBaloncesto("Jonh", 27,1.99);
        JugadorBaloncesto jb4 = new JugadorBaloncesto("Kai", 30,2.09);

        Judoka jdk1 = new Judoka("Kim", 22, 12);
        Judoka jdk2 = new Judoka("Sai", 19, 15);
        Judoka jdk3= new Judoka("Lee", 25, 5);
        Judoka jdk4 = new Judoka("Yamamoto", 30, 10);

        Atleta a1 = new Atleta("SAra", 2, "Maraton");
        Atleta a2 = new Atleta("Esther", 27, "500m");
        Atleta a3 = new Atleta("SAra", 30, "salto de valla");
        Atleta a4 = new Atleta("SAra", 18, "Maraton");

        Pais pais1 = new Pais("España", 20);
        Pais pais2 = new Pais("Italia", 15);
        Pais pais3 = new Pais("Francia", 30);

        ed1.addPais(pais1);
        ed1.addPais(pais2);
        ed1.addPais(pais3);

        //ed1.mostrarPaises();

        Atletismo aa1 = new Atletismo("100 lisos", "Coral",1);
       Judo j1 = new Judo("sub16", "Tami", 4);
       Baloncesto b1 = new Baloncesto("sub19", "alkdf", 4);

       ed1.addDeporte(aa1);
       ed1.addDeporte(j1);
       ed1.addDeporte(b1);

       // System.out.println(ed1);

        b1.addParticipante(jb1);
        b1.addParticipante(jb2);
        b1.addParticipante(jb3);
        b1.addParticipante(jdk1);

        b1.mostrarParticipantes();
        b1.mostrarJugadoresBaloncestoPorAltura();
    }
}
