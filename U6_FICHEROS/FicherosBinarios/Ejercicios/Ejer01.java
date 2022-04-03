package com.company.FicherosBinarios.Ejercicios;

import java.io.*;
import java.util.Scanner;

/*
Actividad 1. Pedir un double por consola y guardarlo en un archivo binario.

 */
public class Ejer01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero binario: ");
        ObjectOutputStream n = null;
        try {
            n= new ObjectOutputStream(new FileOutputStream("datos.dat"));
            Double num = sc.nextDouble();
            n.writeObject(num);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (n != null)
                    n.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
