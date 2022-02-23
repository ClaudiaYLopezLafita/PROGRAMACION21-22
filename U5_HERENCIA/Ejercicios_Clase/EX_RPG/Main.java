package com.company.EX_RPG;

public class Main {
    public static void main(String[] args) {
        Elfo e1 = new Elfo("Legolas", 100,100,100, false, Tipo.BOSQUE);
        Orco o1 = new Orco("GRU", 100,100,50, true, 250.2);
        Guerrero g1 = new Guerrero("Aragor", 200,100,75,false,63);

        System.out.println(e1);
        System.out.println(o1);

        e1.atacarPersonaje(o1);

        RPG juego = new RPG();

        juego.addPersonaje(e1);
        juego.addPersonaje(g1);

        System.out.println(juego);

        juego.mostrarEstado();
        juego.borrarMuertos();
        juego.mostrarxAtaque();
        juego.mostrarxDefensa();
    }
}
