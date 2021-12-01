package com.company;
/*

Realiza un programa que muestre por pantalla un array bidimensional cuadrado cuyo tamaño será solicitado
al usuario y que deberá rellenarse con números entre 18 y 65.

A continuación, el programa debe mostrar los números de la diagonal que van desde la esquina
superior izquierda a la esquina inferior derecha, así como el máximo, el mínimo y la media de los números que hay en esa diagonal.

Se valorará que la solución requiera el mínimo número de recorridos posibles del array.
 */

import java.util.Scanner;

public class Ej03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("INtroduce el tamaño del Array: ");
        int tamaño = sc.nextInt();

        int [][] numero = new int[tamaño][tamaño];
        int numMayor = 0;
        int numMenor = 64;
        int sum=0,cantNum=0;


        for (int i = 0; i < numero.length; i++) {
            for (int j = 0; j < numero[i].length; j++) {
                int num = (int) (Math.random()*(65-18)+18);
                numero[i][j] = num;
                if (i==j){
                    System.out.print(num);
                    sum+=num;
                    if (num>numMayor){
                        numMayor = num;
                    }
                    if (num<numMenor){
                        numMenor = num;
                    }
                    cantNum++;
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("El mayor de los numero es: "+numMayor);
        System.out.println("El menor de los numero es: "+numMenor);
        System.out.println("La media de los numero es: "+(sum/cantNum));

    }
}
