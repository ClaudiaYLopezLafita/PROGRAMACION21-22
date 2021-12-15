package com.company;
/*
Realizar una función mediaVectores que:

Recibe dos vectores de enteros de una dimensión
Devuelve un único vector de float cuyos elementos serán las medias de los elementos de dicha posición
en los vectores recibidos.
En caso de que uno de los dos vectores sea más largo, en las posiciones restantes se colocarán
los valores del vector más largo.
Los vectores deberán ser rellenados por el usuario. Se le solicitará el tamaño y los valores de los dos.

Ejemplo:

Si v1 = {1,2,4} y v2 = {3,4,5,6,7,8}

mediaVectores(v1,v2) debe devolver {2,3,4.5,6,7,8}
 */

import java.util.Arrays;
import java.util.Scanner;

public class Ej01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿De que tamaña quieres el primer vector?");
        int tam1 = sc.nextInt();
        System.out.println("¿De que tamaño quieres el segundo vector?");
        int tam2 = sc.nextInt();

        int[] v1 = new int[tam1];
        int[] v2 = new int[tam2];

        System.out.println();
        System.out.println("Rellena tu primer array");
        for (int i = 0; i < v1.length; i++) {
            v1[i] = sc.nextInt();
        }

        System.out.println();
        System.out.println("Rellena tu segundo array");
        for (int i = 0; i < v2.length; i++) {
            v2[i] = sc.nextInt();
        }

        System.out.println();
        System.out.println("El array de las medias es: ");
        System.out.println(Arrays.toString(mediaVector(v1, v2)));

    }

    public static float[] mediaVector(int[] a, int[] b){
        float[] resultado = new float[0];

        if (a.length==b.length){
            for (int i = 0; i < a.length; i++) {
                resultado = Arrays.copyOf(resultado, resultado.length+1);
                resultado[resultado.length-1] = (float) ((double) (a[i]+b[i])/2);
            }
        } else {

            int tamMenor = (a.length > b.length ? b.length : a.length);

            for (int i = 0; i < tamMenor; i++) {
                resultado = Arrays.copyOf(resultado, resultado.length + 1);
                resultado[resultado.length - 1] = (float) ((double) (a[i] + b[i]) / 2);
            }

            int[] vMayor = (a.length > b.length ? a : b);

            for (int i = tamMenor; i < vMayor.length; i++) {
                resultado = Arrays.copyOf(resultado, resultado.length + 1);
                resultado[resultado.length - 1] = (float) (double) vMayor[i];
            }
        }

        return resultado;
    }
}
