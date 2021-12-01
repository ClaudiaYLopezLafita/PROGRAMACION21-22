package com.company;

import java.util.Arrays;
import java.util.Scanner;

/*
Desarrollar una función que se denomine desplazarMatriz. Dicha función:

Recibirá como parámetro un vector bidimensional de enteros y el número de columnas que hay que desplazar
la matriz. Devolverá como resultado un vector bidimensional que moverá las columnas de la matriz de
entrada hacia la derecha tantas posiciones como se especifique en el segundo parámetro.

 */
public class Ej04 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int[][] numeros ={
                {1,2,3},
                {5,6,7},
                {9,10,11},
        };

        System.out.println("¿cuanto quieres desplazar la columan?");
        int desplaza = sc.nextInt();

        for ( int[] row : numeros ) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();
        System.out.println("Tu array desplazado es:");
        for (int[] row:desplazarMatriz(numeros, desplaza)) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] desplazarMatriz(int[][] v, int num){
        int[][] resultado = new int[v.length][v.length];

            for (int i = 0; i < v.length; i++) {
                for (int j = 0; j < v[i].length; j++) {
                        resultado[i][(j+num)%v.length] = v[i][j];
                }
            }
        return resultado;
    }
}
