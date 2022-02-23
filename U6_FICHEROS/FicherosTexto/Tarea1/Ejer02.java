package com.company.FicherosTexto.Tarea1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
Diseñar una aplicación que pida al usuario su nombre y edad. Estos datos deben guardarse en el
fichero "datos.txt". Si este fichero existe, debe borrarse su contenido, y en caso de no existir,
debe crearse.
 */
public class Ejer02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Indica tu nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Indica tu edad: ");
        String edad = sc.nextLine();

        try {
            FileWriter f2 = new FileWriter("ficheros/datos.txt");
            f2.write("Nombre: "+nombre+'\n');
            f2.write("Edad: "+edad+'\n');
            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
