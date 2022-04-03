package com.company.FicherosBinarios.Complementarios;

import java.io.*;
import java.util.Arrays;

/*
Crear una tabla de 10 num enteros aleatorios menos que 100, ordenandodos de menos a mayot y guardarlos
en un fichero binarios. A continuacion recuperlos y mostaelos por consola.
 */
public class Ejer05 {
    public static void main(String[] args) {

        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        Integer[] numeros = new Integer[10];

        try {
            for (int i = 0; i < numeros.length; i++) {
                numeros[i] = (int)(Math.random()*101);
            }
            out = new ObjectOutputStream(new FileOutputStream("numOrdenados.dat"));
            Arrays.sort(numeros);
            out.writeObject(numeros); // guardamos el array en el fichero

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {// abrimos un flujo de entrada para lee los números.
            in = new ObjectInputStream(new FileInputStream("numOrdernados.dat"));
           try{
               numeros = (Integer[]) in.readObject(); // leemos un OBJECT que se transformara en Interger[]
           }catch (IOException e){
               e.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
            System.out.println(Arrays.toString(numeros)); // mostranos por consola
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
