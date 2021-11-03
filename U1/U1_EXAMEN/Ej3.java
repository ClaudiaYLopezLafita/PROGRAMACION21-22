package com.company;

import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
    /*
    Realiza un programa que muestre al azar el nombre de una carta de la baraja francesa.
    Esta baraja está dividida en cuatro palos: picas, corazones, diamantes y tréboles.
    Cada palo está formado por 13 cartas, de las cuales 9 cartas son numerales y 4
    literales: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K y A (que sería el 1).  Deberemos por tanto generar
     de manera aleatoria primero el palo y posteriormente la carta perteneciente al plo.
     */
        Scanner sc = new Scanner(System.in);

        int randomPalo = (int) (1* Math.random() *5);
        if (randomPalo==1){
            System.out.println("Palo - Trebol");
        } else if (randomPalo==2){
            System.out.println("Palo - Corazon");
        } else if (randomPalo==3){
            System.out.println("Palo - DIamante");
        }else if (randomPalo==3){
            System.out.println("Palo - Pica");
        }

        int randomCarta = (int) (2 * Math.random() *10);
        System.out.println("Carta - "+randomCarta);

    }
}
