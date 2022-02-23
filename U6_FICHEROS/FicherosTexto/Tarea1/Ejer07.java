package com.company.FicherosTexto.Tarea1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/*
En LINUX disponemos de un comando "more", al que se le pasa un fichero y lo muestra poco a poco (cada 24 líneas).
Implementar un programa que funcione de forma similar.
 */
public class Ejer07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int BLOQUE = 24;
        int contador =0;


        try {
            BufferedReader in = new BufferedReader(new FileReader("ficheros/texto.txt"));
            String linea = in.readLine();
            String texto = "";
            while (linea!=null){
                contador++;
                if (contador==BLOQUE){
                    texto+=linea+'\n';
                } else {
                    System.out.println(texto);
                    contador=0; // volvemos a empezar a contar
                    texto="";
                    System.out.print("ENTER PARA CONTINUAR");
                    sc.nextLine();
                }

                linea = in.readLine(); // volvemos a leer linea
            }

            if (texto!=""){
                System.out.println(texto);
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
