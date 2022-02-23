package com.company.Vehiculos;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Coche c1 = new Coche("Herby",4,"3333XXX",Color.AMARILLO, 1960);
        Coche c2 = new Coche("KITT",2,"444XXX",Color.ROJO,1980);
        Coche c3 = new Coche("Rayo McQueen",3,"5555XXX",Color.ROJO,2005);

        Motocicleta m1 = new Motocicleta("Honda",1,"6666XXX",Color.AMARILLO,1960);
        Motocicleta m2 = new Motocicleta("Yamaha",2,"777XXX",Color.ROJO,1980);
        Motocicleta m3 = new Motocicleta("Harley",1,"888XXX",Color.ROJO,2005);

        Helicoptero h = new Helicoptero("Rusty",10,1000,"C-100");
        Avioneta a = new Avioneta("McFly",11,2000,"C-200");

        Terrestre[] t = {c1,c2,c3,m1,m2,m3};

        System.out.println(Arrays.toString(t));

        Arrays.sort(t);

        System.out.println(Arrays.toString(t));

        Arrays.sort(t,new ComparadorYear());

        System.out.println(Arrays.toString(t));

        h.transportar(9);

        System.out.println(h);
    }
}
