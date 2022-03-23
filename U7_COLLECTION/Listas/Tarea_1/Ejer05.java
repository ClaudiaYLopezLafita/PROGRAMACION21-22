package com.company.Listas.Tarea1;
import java.util.ArrayList;

/*
Crear una colección de 20 números enteros aleatorios distintos menores que 100, guardarlos por orden decreciente
a medida que se vayan generando, y mostrar la colección por pantalla.
 */
public class Ejer05 {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Integer num = (int)(Math.random()*100);
            numeros.add(num);
        }

        System.out.println(numeros);
    }
}
