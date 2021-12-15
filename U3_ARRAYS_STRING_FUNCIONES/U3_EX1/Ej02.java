package com.company;
/*
Crear una función insertarValor que:

Reciba como parámetros un vector de enteros, un valor y una posición
Devuelva como resultado un vector en el que habremos insertado el valor que le hemos pasado
en la posición indicada. De esta manera el vector resultado tendrá un elemento más.
Realizar una llamada a la función mostrando el vector resultado.

Ejemplo:

v = { 1 , 2 , 3 , 4 , 5 }
v1 = invertarValor(v,8,3)
Entonces v1 será {1,2,3,8,4,5}
 */

import java.util.Arrays;
import java.util.Scanner;

public class Ej02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros;

        System.out.print("¿Que tamaño quieres en un vector?: ");
        int respesutas = sc.nextInt();

        numeros = new int[respesutas];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random()*100);
        }

        System.out.println(Arrays.toString(numeros));
        System.out.println();

        System.out.print("¿Que valor quieres intoducir?: ");
        int valor = sc.nextInt();
        System.out.println("¿En que posicion quieres insertar el valor?: ");
        int posicion = sc.nextInt();

        System.out.println(Arrays.toString(insertarValor(numeros,valor,posicion)));
    }

    public static int[] insertarValor(int[] v, int a, int p){
        int j =0;
        int[] resultado = new int[v.length+1];

        for (int i = 0; i < resultado.length; i++) {
            if (i==p){
                resultado[i]=a;
            } else {
                resultado[i]=v[j];
                j++;
            }
        }

        return resultado;
    }
}
