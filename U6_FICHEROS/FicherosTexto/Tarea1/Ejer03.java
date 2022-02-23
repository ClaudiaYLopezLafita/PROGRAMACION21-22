package com.company.FicherosTexto.Tarea1;

import java.io.*;
import java.net.ServerSocket;
import java.util.Scanner;

/*
Crear un programa que duplique el conenido de un fichero. Realizar dos versiones:

Duplicaremos el fichero original.txt en uno que se llame copia.txt
Pedir el nombre del fichero fuente y duplicarlo en un fichero con el mismo nombre con el prefijo "copia_de".
 */
public class Ejer03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el nombre del fichero: ");
        String nombre = sc.nextLine();

        try {
            BufferedReader in = new BufferedReader(new FileReader(nombre));
            BufferedWriter out = new BufferedWriter(new FileWriter("Copia_de_"+nombre));
            String linea = in.readLine();
            while (linea!=null){
                out.write(linea+'\n');// volcamos en el fichoerp lo que vamos escribiendp
                linea = in.readLine();
            }
            in.close();
            out.close(); // cerramos los dos porque ya hemos terminado de leer y de escribi
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
