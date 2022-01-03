package com.company;
/*
Implementa una función con nombre nEsimo que busque el número que hay
dentro de un array bidimensional en la posición n-ésima contando de
izquierda a derecha y de arriba abajo, como si se estuviera leyendo.
El primer elemento es el 0. Si la posición donde se busca no existe en
el array, la función debe devolver -1. Se debe entregar tanto el
código de la función como el código de prueba que la usa. La cabecera
de la función es la siguiente:
public static int nEsimo(int[][] n, int posicion)
 */
import java.util.Arrays;
import java.util.Scanner;

public class Ej19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Intrdoduce el numero de filas: ");
        int numFila = sc.nextInt();
        System.out.print("Intrdoduce el numero de columnas: ");
        int numCol = sc.nextInt();
        System.out.print("¿Qué posicion quieres mirar?: ");
        int pos = sc.nextInt();

        int[][] num = new int[numFila][numCol];

        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = (int) (Math.random()*(100));
            }
        }

        System.out.println("Tu array original es: ");
        for (int[] row : num) {
            System.out.println(Arrays.toString(row));
        }
        System.out.print("El Enesimo de la posicion "+pos+" es: "+nEsimo(num,pos));

    }

    public static int nEsimo(int[][] n, int posicion){
        int pos = 0;

        for (int i = 0; i < n.length ; i++) {
            for (int j = 0; j < n[i].length; j++) {
                if (pos == posicion){
                    return n[i][j];
                }
                pos++;
            }
        }

        return -1;
    }
}
