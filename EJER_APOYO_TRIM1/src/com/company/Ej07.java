package com.company;
/*
Realiza un programa que muestre por pantalla un array de 10 filas por
10 columnas relleno con números aleatorios entre 200 y 300. A
continuación, el programa debe mostrar los números de la diagonal que
va desde la esquina superior izquierda a la esquina inferior derecha,
así como el máximo, el mínimo y la media de los números que hay en esa
diagonal.
 */
public class Ej07 {
    public static void main(String[] args) {
        int[][] num = new int[10][10];
        int numMayor=200;
        int numMenor=300;
        int suma =0;
        int cantNum=0;

        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = (int) (Math.random()*(300-200+1)+200);
                if (i == j){
                    cantNum++;
                    System.out.print(num[i][j]);
                    if (num[i][j]>numMayor){
                        numMayor = num[i][j];
                    }
                    if (num[i][j]<numMenor){
                        numMenor = num[i][j];
                    }
                    suma +=num[i][j];
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("El numero mas alto es: "+numMayor);
        System.out.println("El numero mas bajo es: "+numMenor);
        System.out.println("La media de los nuemros es: "+(suma/cantNum));
    }
}
