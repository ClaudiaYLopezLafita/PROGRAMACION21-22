package com.company.FicherosTexto.Tarea1;

import java.io.*;
import java.util.Arrays;

/*
Disponemos de dos ficheros perso1.txt y perso2.txt con nombres de personas (ambos ordenados).
Realizar un programa que lea ambos ficheros y que cree un tercer fichero  (todos.txt)
con todos los nombres ordenados alfabéticamente.
 */
public class Ejer08 {
    public static void main(String[] args) {

        String[] nombres = new String[0];

        try {
            BufferedReader in = new BufferedReader(new FileReader("firmas.txt"));
            String linea = in.readLine();
            while (linea!=null) {
                nombres = Arrays.copyOf(nombres,nombres.length+1);
                nombres[nombres.length-1]=linea;
                linea = in.readLine();
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader in = new BufferedReader(new FileReader("firmas2.txt"));
            String linea = in.readLine();
            while (linea!=null) {
                nombres = Arrays.copyOf(nombres,nombres.length+1);
                nombres[nombres.length-1]=linea;
                linea = in.readLine();
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Arrays.sort(nombres);

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("salida.txt"));

            for (String n:nombres) {
                out.write(n);
                out.newLine();
            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
