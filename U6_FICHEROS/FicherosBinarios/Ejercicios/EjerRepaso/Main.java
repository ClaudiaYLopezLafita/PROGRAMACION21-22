package com.company.FicherosBinarios.Ejercicios.EjerRepaso;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Manuel", "Lopez", "C/ Conde",  "123456789");
        Persona p2 = new Persona("Maria", "Hermoso", "C/ Real",  "987654321");
        Persona p3 = new Persona("Claudia", "Lafita", "C/ Bustos",  "456321789");
        Persona p4 = new Persona("Pepe", "Escobar", "C/ Giralda",  "654789321");
        Persona p5 = new Persona("Ivan", "MOreno", "C/ Orfila",  "741852963");

        Persona[] personas = {p1, p2, p3, p4, p5};

        System.out.println(Arrays.toString(personas));


    }
}
