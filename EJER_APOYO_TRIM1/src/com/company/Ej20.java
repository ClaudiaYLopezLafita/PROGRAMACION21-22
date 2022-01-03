package com.company;
/*
Crea las funciones cuyas cabeceras se muestran a continuación, observa
que tienen el mismo nombre:

public static int ocurrencias(int digito, int n)
public static int ocurrencias(int digito, int[] a)

La función ocurrencias devuelve el número de veces que aparece un
dígito dentro de un número (primera función) o bien el número de veces
que aparece un dígito en una serie de números contenidos en un array
(segunda función).
 */

import java.util.Scanner;

public class Ej20 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        

        System.out.println("Introduce un numero: ");
        int num = sc.nextInt();
        System.out.println("¿Que números buscas?");
        int resp = sc.nextInt();

        int[] nums = new int[5];
        System.out.println("rellena tu array un numero: ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("¿Que números buscas?");
        int resp2 = sc.nextInt();


        System.out.println("El digito que buscas aparece "+ocurrencias(resp, num)+" veces.");
        System.out.println("El digito que buscas en el array aparece "+ocurrencias(resp2, nums)+" veces.");

    }

    public static int ocurrencias(int digito, int n){
        int resultado =0;

        while (n >0){
            int cifra = n%10;
            if (cifra == digito){
                resultado++;
            }
            n/=10;
        }

        return resultado;
    }
    
    public static int ocurrencias(int digito, int[] a){
        int resultado=0;

        for (int i = 0; i < a.length; i++) {
            while (a[i]>0) {
                int cifra = a[i]%10;
                if (cifra == digito){
                    resultado++;
                }
                a[i]/=10;
            }
        }

        return resultado;
    }
}
