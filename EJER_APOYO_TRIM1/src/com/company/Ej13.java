package com.company;

import java.util.Arrays;
import java.util.Scanner;

/*
Ejercicio 13
Crea la función de manejo de arrays que tenga la siguiente cabecera y que haga lo que se
especifica en los comentarios (puedes incluirla en tu propia biblioteca de rutinas):

public static int[] filtraPrimos(int x[])
// Devuelve un array con todos los números primos que se encuentren en otro array que se
pasa como parámetro. Obviamente el tamaño del array que se devuelve será menor o igual al que se pasa como
parámetro.

Utiliza esta función en un programa para comprobar que funcionan bien. Para que el ejercicio
resulte más fácil, las repeticiones de primos se conservan; es decir, si en el array x
el número 13 se repite 3 veces, en el array devuelto también estará repetido 3 veces. Si no existe
ningún número primo en x, se devuelve un array con el número -1 como único elemento.
 */
public class Ej13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿De que tamaño quieres tu array??");
        int tam = sc.nextInt();

        int[] num = new int[tam];

        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random()*101);
        }

        System.out.println();
        System.out.println("Tu array original es: ");
        System.out.println(Arrays.toString(num));
        System.out.println("Tu array de solo primos es: ");
        System.out.println(Arrays.toString(filtraPrimos(num)));

    }

    public static int[] filtraPrimos(int x[]){
        int[] resultado = new int[0];

        for (int i = 0; i < x.length; i++) {
            if (esPrimo(x[i])){
                resultado = Arrays.copyOf(resultado, resultado.length+1);
                resultado[resultado.length-1] = x[i];
            }
        }

        if (resultado.length == 0){
            resultado = Arrays.copyOf(resultado, resultado.length+1);
            resultado[resultado.length-1] = -1;
        }

        return resultado;
    }

    public static boolean esPrimo( int x){
        for (int i = 2; i < x; i++) {
            if (x%i==0){
                return false;
            }
        }

        return true;
    }
}
