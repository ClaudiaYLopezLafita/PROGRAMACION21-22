package com.company.Listas.Tarea1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/*
Actividad 1: Crear una colección de 20 números enteros aleatorios menores que 100, y guardarlos en el orden en que
 se vayan generando; mostrar por pantalla dicha lista una vez creada. Ordenarla en sentido creciente y volverla
 a mostrar por pantalla.
 */
public class Ejer01 {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            Integer num = (int)(Math.random()*100);
            numeros.add(num);
        }
          /*
        Podemos llamar al metodo sort de la clase padre y le pasamos como parámetro el ArrayList
         */
        System.out.println(numeros);
        Collections.sort(numeros);
        System.out.println(numeros);

//        numeros.toString();
//        System.out.println(numeros);

//        // FORMAS DE RECORRAR UNA LISTA
//
//            // foreach
//        for (Integer i: numeros) {
//            System.out.print(i+"-");
//        }
//        System.out.println();
//            // size
//        for (int i = 0; i < numeros.size(); i++) {
//            System.out.print(numeros.get(i)+"-");
//        }
//        System.out.println();
//            // literal: iterador = cursores
//        Iterator it = numeros.iterator();
//        while (it.hasNext()){
//            Integer num = (Integer) it.next();
//            System.out.print(num+"-");
//        }

    }
}
