package com.company.FicherosTexto.Tarea1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
En el archivo numeros.txt disponemos de una serie de números (uno por cada línea). Diseñar un
programa que procese el fichero y nos muestre el menor y el mayor.
 */
public class Ejer05 {
    public static void main(String[] args) {
        String texto="";
        int mayor=0;
        int menor=0;
        try {
            BufferedReader in = new BufferedReader(new FileReader("ficheros/numeros.txt"));
            String linea = in.readLine();
            mayor = Integer.parseInt(linea);
            menor = Integer.parseInt(linea);

            while (linea != null) {
                int n = Integer.parseInt(linea);
                if (n > mayor){
                    mayor = n;
                }
                if (n < menor){
                    menor = n;
                }
                linea = in.readLine();
            }
            in.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("el numero mas alto es: "+mayor);
        System.out.println("el numero mas bajos es: "+menor);
    }
}
