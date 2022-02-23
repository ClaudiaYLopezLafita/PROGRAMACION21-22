package com.company.FicherosTexto.Tarea1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

/*
Realizar un programa que lea un fichero de texto llamado carta.txt, tenemos que contar
los caracteres, las líneas y las palabras. Para facilitar el procesamiento supondremos que
cada palabra está separada de otra por un único espacio en blanco.
 */
public class Ejer04 {
    public static void main(String[] args) {
        int numCaracteres=0;
        int numPalabras =0;
        int numLineas=0;
        String texto2 = " ";
        String texto = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader("ficheros/carta.txt"));
            String linea = in.readLine()+'\n';
            while (linea != null) {
                texto += linea;
                numLineas++;
                numCaracteres+=linea.length();
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i)==' ') {
                        numPalabras++;
                    }
                }

                /*

                 */
                linea = in.readLine();
            }
            in.close();
            //f1.read();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(texto);
        System.out.println();
        System.out.println("Numero de caracteres: "+numCaracteres);
        System.out.println("NUmeros de Lienas: "+numLineas);
        System.out.println("Numero de Palabras: "+(numPalabras+2));
    }
}
