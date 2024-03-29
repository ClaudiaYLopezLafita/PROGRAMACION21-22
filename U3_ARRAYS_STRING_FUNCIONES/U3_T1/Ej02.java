package com.company;

import java.util.Arrays;

/*
Define tres arrays de 20 números enteros cada una, con nombres numero , cuadrado y cubo .
Carga el array numero con valores aleatorios entre 0 y 100. En el array cuadrado se deben almacenar
los cuadrados de los valores que hay en el array numero . En el array cubo se deben almacenar los cubos
de los valores que hay en numero . A continuación, muestra el contenido de los tres arrays dispuesto en
 tres columnas.
 */
public class Ej02 {
    public static void main(String[] args) {
        int[] numero = new int[20];
        int[] cuadrado = new int[20];
        int[] cubo = new int[20];

        for (int i = 0; i < numero.length; i++) {
            int num = (int) (Math.random()*(100-0)+0);
            numero[i]=num;
        }

        for (int i = 0; i < cuadrado.length; i++) {
            cuadrado[i]=(numero[i]*numero[i]);
        }

        for (int i = 0; i < cubo.length; i++) {
            cubo[i]=(numero[i]*numero[i]*numero[i]);
        }

        for (int i = 0; i < numero.length; i++) {
            System.out.print(numero[i]+"| ");
            System.out.print(cuadrado[i]+"| ");
            System.out.println(cubo[i]);
        }

    }
}
