package com.company.Listas.Tarea1;

import java.util.ArrayList;
import java.util.Collections;
/*
Actividad 3: Crear una colección de 20 números enteros aleatorios menores que 10,
guardarlos por orden decreciente a medida que se vayan generando y mostrar la colección por pantalla.
 */
public class Ejer03 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            Integer num = (int)(Math.random()*10);
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
