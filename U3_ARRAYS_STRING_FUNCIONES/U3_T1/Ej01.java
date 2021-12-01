package com.company;

import java.util.Arrays;

/*
Desarrollar una función que se denomine interseccionVectores. Dicha función:
Recibirá como parámetros dos vectores de enteros.
Devolverá un vector de enteros que contenga los números que estén en los dos vectores recibidos como parámetros. Dicho vector deberá devolverse ordenado.
Probar dicha función en el método Main.

Ejemplo 1:

v1 = {1,2,3,4,5,6}
v2 = {3,9,12,5,7}

El resultado de interseccionVectores será:
{3,5}
 */
public class Ej01 {
    public static void main(String[] args) {

        int [] v1 = {1,2,3,4,5,6};
        int [] v2 = {10,23,56,8,2,3};

        System.out.println(Arrays.toString(v1));
        System.out.println(Arrays.toString(v2));
        System.out.println(Arrays.toString(interseccionVectores(v1,v2)));

        int[] c = {6,12,8,9,3,13};
        int[] d = {13,11,4,8,6,1};

        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(interseccionVectores(c,d)));
    }

    public static int[] interseccionVectores(int[] a, int[] b) {

        int[] result = new int[0];

        for (int i = 0; i < a.length; i++) {
            if (esta(b,a[i])) {
                result = Arrays.copyOf(result,result.length+1);
                result[result.length-1] = a[i];
            }
        }

        return result;
    }

    public static boolean esta(int[] vector, int b) {

        for (int i = 0; i < vector.length; i++) {
                if (vector[i]==b) {
                    return true;
                }


        }
        return false;
    }
}
