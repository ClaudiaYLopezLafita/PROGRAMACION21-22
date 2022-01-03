package com.company;
/*
Realiza un programa que rellene un array con 10 números aleatorios
comprendidos entre 2 y 100 (ambos incluidos) y que los muestre por
pantalla. A continuación, el programa indicará para cada uno de ellos
si es un número primo y/o un capicúa de la forma que muestra el
 */

import java.util.Arrays;
import java.util.Scanner;

public class Ej18 {
    public static void main(String[] args) {
        int[] num = new int[10];

        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random()*(201-2)+2);
        }

        System.out.println(Arrays.toString(num));

        for (int i = 0; i < num.length; i++) {
            if (esPrimo(num[i]) && esCapicua(num[i])){
                System.out.println("El "+num[i]+" es primo y es capicua");
            } else if (esPrimo(num[i]) && !esCapicua(num[i])){
                System.out.println("El "+num[i]+" es primo y no es capicua");
            } else if (!esPrimo(num[i]) && esCapicua(num[i])){
                System.out.println("El "+num[i]+" no es primo y es capicua");
            } else if (!esPrimo(num[i]) && !esCapicua(num[i])){
                System.out.println("El "+num[i]+" no es primo y no es capicua");
            }
        }
    }
    
    public static boolean esPrimo(int a){

        for (int i = 2; i < a; i++) {
            if (a%i==0){
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean esCapicua(int a){
        int aux, inverso = 0, cifra;

        //le damos la vuelta al número
        aux = a;
        while (aux>0){
            cifra = aux % 10;
            inverso = inverso * 10 + cifra;
            aux                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 /=10;
        }
        // comparamos si el numero es igual a inverso
        if(a == inverso){
            return true;
        }else{
            return false;
        }
    }
}
