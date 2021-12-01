package com.company;

import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*Realizar un conversor del sistema decimal al sistema de asteriscos que sustituye cada
        cifra por un número correspondiente de asteriscos (*) y separa las cifras con un guión.
         */
        int num;
        int resto=0, numReves=0;
        int numDigitos=0;

        System.out.println("INtroduce un numero");
        num = sc.nextInt();

        while (num>0){
            resto=num%10;
            num/=10;
            numReves =(numReves*10)+resto;
            numDigitos++;
        }

        int numAux=0;

        while (numReves>0){
         numReves/=10;
         numAux = (numAux*10)+numReves%10;
        }

        for (int i = 0; i < numDigitos; i++) {
            if (numReves==1){
                System.out.println("-*-");
            } else if (numReves==2){
                System.out.print("-**-");
            } else if (numReves==3){
                System.out.print("-***-");
            } else if (i==4){
                System.out.print("-****-");
            } else if (i==5){
                System.out.print("-*****-");
            } else if (i==6){
                System.out.print("-******-");
            } else if (i==7){
                System.out.print("-*******-");
            }else if (i==8){
                System.out.print("-********-");
            } else if (i==9){
                System.out.print("-*********-");
            }
        }





    }
}
