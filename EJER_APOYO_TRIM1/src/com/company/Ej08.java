package com.company;

import java.util.Arrays;
import java.util.Scanner;

/*
Realiza un programa que pida 10 números por teclado y que los almacene
en un array. A continuación, se mostrará el contenido de ese array
junto al índice (0 – 9) utilizando para ello una tabla. Seguidamente
el programa pasará los primos a las primeras posiciones, desplazando
el resto de números (los que no son primos) de tal forma que no se
pierda ninguno. Al final se debe mostrar el array resultante.
 */
public class Ej08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] indice ={"0","1","2","3","4","5","6","7","8","9"};
        int[] num = new int[10];
        int[] resultado = new int[0];

        System.out.println("Rellena tu Array: ");
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
            
            if (esPrimo(num[i])){
                resultado = Arrays.copyOf(resultado, resultado.length+1);
                resultado[resultado.length-1] = num[i];
            }
        }

        for (int j = 0; j < num.length; j++) {
            if (!esPrimo(num[j])){
                resultado = Arrays.copyOf(resultado, resultado.length+1);
                resultado[resultado.length-1] = num[j];
            }
        }

        System.out.println("Tu array original es: ");
        System.out.println(Arrays.toString(num));
        System.out.println();
        System.out.println("Tu array modificado es: ");
        System.out.println(Arrays.toString(resultado));
    }
    
    public static boolean esPrimo(int x){
        boolean esPrimo = true;
        
        for (int i = 2; i < x; i++) {
            if (x%i == 0){
                esPrimo = false;
                break;
            } else {
                esPrimo = true;
            }
        }
        
        return esPrimo;                
    }
}
