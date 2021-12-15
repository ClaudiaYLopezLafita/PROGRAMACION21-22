package com.company;
/*
Escribe un programa que al usuario un número entero y rellene una matriz cuadrada de de esas
dimensiones con valores entre 100 y 200.

A continuación se pasará esa matriz a la función numPicos que nos devolvéra el número de celdas
de la matriz bidimensional que son mayores o iguales que todos sus vecinos adyacentes.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Ej03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] numeros;

        System.out.println("¿De que tamaño quieres tu vector?: ");
        int tam = sc.nextInt();

        numeros= new int[tam][tam];

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                int val = (int) (Math.random()*(200-100)+100);
                numeros[i][j] = val;
            }
        }

        for (int[] row : numeros) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println(numPicos(numeros));
    }

    public static int numPicos(int[][] x){

        int catidad=0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                if (esMayor(x,x[i][j])){
                    catidad++;
                }
            }
        }


        return catidad;
    }

    public static boolean esMayor(int[][]x, int a){
            // funcion que debe compartar un valor con sus conlindadntes e indicar si es o no mayor a TODOS

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {

                if (estaDentro(i, j, x) && (a > x[i - 1][j - 1] && a > x[i - 1][j] && a > x[i - 1][j + 1] && a > x[i - 1][j + 1]
                            && a > x[i + 1][j + 1] && a > x[i + 1][j] && a > x[i + 1][j - 1] && a > x[i][j - 1])){

                    return true;

                }
            }
        }

        return false;
    }

    public static boolean estaDentro(int x, int b, int[][] z){
        // funcion que debe de incidar si el numero que estamos comparando está o no dentro de nuestro array.

        if (b >= 0 && b <= z.length && x >=0 && x<=z.length){
            return true;
        }

        return false;

    }
}
