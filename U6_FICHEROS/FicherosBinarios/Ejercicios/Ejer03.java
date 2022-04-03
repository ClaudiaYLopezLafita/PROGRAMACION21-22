package com.company.FicherosBinarios.Ejercicios;

import java.io.*;
import java.util.Scanner;

/*
Actividad 3. Pedir números enteros positivos por consola y guardarlos en un fichero binario
hasta que se introduzca un número negativo. Leer del fichero todos los enteros guardados y
mostrarlos por pantalla.
 */
public class Ejer03 {
    public static void main(String[] args) {
        FileOutputStream archivo;
        FileInputStream lectura;
        ObjectOutputStream out = null;
        ObjectInputStream lecturObj=null;
        Scanner sc = new Scanner(System.in);
        int num;

        do {
            System.out.println("Introduce el numero: ");
            num = sc.nextInt();

            if (num>=0){
                try {
                    archivo = new FileOutputStream("Ejer03.dat");
                    out = new ObjectOutputStream(archivo);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (out != null)
                            out.close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        } while (num>=0);


    }
}
