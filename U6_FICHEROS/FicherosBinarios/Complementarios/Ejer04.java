package com.company.FicherosBinarios.Complementarios;

import java.io.*;
import java.util.Scanner;

/*
4. Escribir por teclado una frase y guardarla en un archivo binario.
Despues recuperar el archivo y mostrarla por consola.
 */
public class Ejer04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ObjectOutputStream out = null; // escribir
        ObjectInputStream in = null; // leer

// abrimos el flujo de salida para guardadr una frase en el archivo.
        try {
            System.out.println("Introduce una frase: ");
            String frase = sc.nextLine();
            // indico que archivo zctua en el flujo de salida
            out = new ObjectOutputStream(new FileOutputStream("frase.dat"));
            out.writeObject(frase);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
/// abrimos un flujo de entrada asociado al mismo archivo
        try {
            in = new ObjectInputStream(new FileInputStream("frase.dat"));
            System.out.println((String) in.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
