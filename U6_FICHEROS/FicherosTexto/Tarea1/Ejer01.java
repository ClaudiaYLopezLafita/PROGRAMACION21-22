package com.company.FicherosTexto.Tarea1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;


/*
Realizar un programa que solicite al usuario el nombre de un fichero de texto y muestre
su contenido en pantalla. Si no se proporciona ningún nombre de fichero, la aplicación utilizará
por defecto "prueba.txt".
 */
public class Ejer01 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime el nombre de tu fichero con la extension: ");
        String respuesta = sc.nextLine();

        if (respuesta.equals("")){
            respuesta = "ficheros/prueba.txt";
        }

        String texto = "";
        try {
            FileReader f1 = new FileReader(respuesta);
            int c = f1.read();
            while (c != -1) {
                texto += (char) c;
                c = f1.read();
            }
            f1.read();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(texto);
    }
}
