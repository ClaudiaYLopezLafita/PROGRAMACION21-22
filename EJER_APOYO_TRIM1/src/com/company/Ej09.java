package com.company;
/*
Realiza un generador de melodía con las siguientes condiciones:
a) Las notas deben estar generadas al azar. Las 7 notas son do, re,mi, fa, sol, la y si.
b) Una melodía está formada por un número aleatorio de notas mayor o igual a 4, menor o igual a 28
y siempre múltiplo de 4 (4, 8,12…).
c) Cada grupo de 4 notas será un compás y estará separado del siguiente compás mediante la barra
vertical “|” (Alt + 1). El final de la melodía se marca con dos barras.
d) La última nota de la melodía debe coincidir con la primera.
 */

public class Ej09 {
    public static void main(String[] args) {
        // al azar obtenemos la cantidad de notas que queremo (siendo estas multiplo de 4)
        int notasTotales = 4 * (int)(Math.random() * (7-0+1)+0);
        String nota = "";
        String primeraNota = "";

        for (int i = 1; i <= notasTotales; i++) {
            int notas = (int) (Math.random() * 7); //obtenemos notas para cada posicion
            switch (notas) {
                case 0:
                    nota = "do";
                    break;
                case 1:
                    nota = "re";
                    break;
                case 2:
                    nota = "mi";
                    break;
                case 3:
                    nota = "fa";
                    break;
                case 4:
                    nota = "sol";
                    break;
                case 5:
                    nota = "la";
                    break;
                case 6:
                    nota = "si";
                    break;
                default:
            }

            if (i == 1) {
                primeraNota = nota;
            } else if (i == notasTotales){
                nota = primeraNota;
            //indicanos que si se llega a la cantidad de notas indicadas la nota final es igual a la primera
            }

            System.out.print(nota+ " ");

            if ( i == notasTotales ) {
                System.out.print("||");
            } else if ( i % 4 == 0 ) { //para saber si se ha rellenado un grupo de 4 notas
                System.out.print("| ");
            }
        }

    }
}
