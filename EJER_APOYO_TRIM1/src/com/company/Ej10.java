package com.company;
/*
Realiza un programa que pinte por pantalla una pecera con un pececito
dentro.
Se debe pedir al usuario el ancho y el alto de la pecera, que como
mínimo serán de 4 unidades. No hay que comprobar que los datos se
introducen correctamente; podemos suponer que el usuario los introduce
bien. Dentro de la pecera hay que colocar de forma aleatoria un
pececito, que puede estar situado en cualquiera de las posiciones que
quedan en el hueco que forma el rectángulo.
 */

import java.util.Scanner;

public class Ej10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la altura de la percera (como mínimo 4): ");
        int altura = sc.nextInt();
        System.out.print("Introduce la anchura de la percera (como mínimo 4): ");
        int anchura = sc.nextInt();

        int[][] pecera = new int[altura][anchura];
        int ipez = (int) (Math.random() * ((altura-1)-1)+1);
        int jpez = (int) (Math.random()* ((anchura-1)-1)+1);
        System.out.println("posicion del pez: ("+ ipez+","+jpez+")");

        for (int i = 0; i < pecera.length; i++) {
            for (int j = 0; j < pecera[i].length; j++) {

                if (i==0 || i == altura-1 || j==0 || j==anchura-1){
                    System.out.print("* ");
                } else if(i==ipez && j == jpez){
                    System.out.print("& ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }
}
