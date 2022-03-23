package com.company.Listas.Tarea1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
Actividad 2: Repetir el ejercicio anterior, pero ordenar la lista en sentido descendente.
 */
public class Ejer02 {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            Integer num = (int)(Math.random()*100);
            numeros.add(num);
        }

         /*
        Podemos llamar al metodo sort de la clase padre y le pasamos como parámetro el ArrayList.
        Además deberemo de implementar una clase que nos para indicar el metodo de ordenación
         */
        Ejer03Num ordenacion = new Ejer03Num();

        System.out.println(numeros);
        Collections.sort(numeros, ordenacion);
        System.out.println(numeros);

    }
}
