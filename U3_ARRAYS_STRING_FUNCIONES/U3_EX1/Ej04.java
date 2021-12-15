package com.company;
/*
Crea dos funciones que trabajen com arrays de dos dimensiones:

int[][] eliminarFilasPares(int[][] matriz) que devuelva el resultado de eliminar de matriz
las filas pares
int[][] eliminarFilasImpares(int[][] matriz) que devuelva el resultado de eliminar de matriz
las filas impares
 */

import java.util.Arrays;
import java.util.Scanner;

public class Ej04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] num;

        System.out.println("De que tamaño quieres tu array?: (introduce un numero par)");
        int tam = sc.nextInt();

        num = new int[tam][tam];

        if (tam % 2 == 0) {
            for (int i = 0; i < num.length; i++) {
                for (int j = 0; j < num[i].length; j++) {
                    num[i][j] = (int) (Math.random() * 100);
                }
            }

            for (int[] row : num) {
                System.out.println(Arrays.toString(row));
            }
        } else {
            System.out.println("Introduce un tamaño par para el Array");
        }

        for (int[] row1 : num) {
            System.out.println(Arrays.toString(eliminarFilasPares(num)));
        }
        System.out.println(Arrays.deepToString(eliminarFilasImpares(num)));
    }

    public static int[][] eliminarFilasPares ( int[][] z){

            int[][] resultado2 = new int[z.length / 2][z.length];


            for (int i = 0; i < z.length; i++) {
                for (int j = 0; j < z[i].length; j++) {
                    if (i % 2 == 0) {
                        resultado2[i][j] = z[i + (1+i)][j];
                    }
                }
            }

            return resultado2;
        }


    public static int[][] eliminarFilasImpares ( int[][] v){

            int[][] resultado1 = new int[v.length / 2][v.length];

            for (int i = 0; i < v.length; i++) {
                for (int j = 0; j < v[i].length; j++) {
                    if (i % 2 != 0) {
                        resultado1[i][j] = v[i+(1+i)][j];
                    }
                }
            }

            return resultado1;
    }


}
